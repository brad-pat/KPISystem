import sys
import mysql.connector

def get_companyname():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    return lines[0].strip().lower()

def get_targets(kpiname, timescale, email):
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=get_companyname())
    cursor = mydb.cursor()
    get_targettable_cmd = str("SELECT target_table FROM kpi_table WHERE kpi_name=%s")
    values = (kpiname,)
    cursor.execute(get_targettable_cmd, values)
    result = cursor.fetchone()
    targettable = str(result).strip()
    tablelen = len(targettable)-3
    tt = str(targettable[2:tablelen]).strip()
    ts = str(timescale[0] + "_t").strip()
    usr = email.split("@")[0].strip().lower()
    get_target_cmd = str("SELECT "+ts+" FROM "+tt+" WHERE user = '"+usr+"'")
    cursor.execute(get_target_cmd)
    result = cursor.fetchone()
    res = str(result).strip()
    tlen = len(res)-2
    print(res[1:tlen])

#get_targets("new_gsv", "daily", "bradley.patrick@telefonica.com")

def main(args):
    if len(args) == 3:
        get_targets(str(args[0]), str(args[1]), str(args[2]))
    else:
        print("Error:Arguements")

if __name__ == "__main__":
    main(sys.argv[1:])
