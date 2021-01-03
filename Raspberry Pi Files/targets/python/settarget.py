import sys
import mysql.connector

def get_companyname():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    return lines[0].strip().lower()


def set_targets(kpiname, timescale, target, email):
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
    usr = email.split("@")[0].strip()
    #print(tt, ts, target, usr)
    set_target_cmd = str("UPDATE " + tt + " SET " + ts + " = %s WHERE user = %s")
    tvalues = (target, usr)
    #print(set_target_cmd, tvalues)
    cursor.execute(set_target_cmd, tvalues)
    print("TARGET SET")
    mydb.commit()
    cursor.close()
    mydb.close()

def main(args):
    if len(args) == 4:
        set_targets(str(args[0]), str(args[1]), float(args[2]), str(args[3]))
    else:
        print("Error:Something went wrong")

if __name__ == "__main__":
    main(sys.argv[1:])
