import sys
import mysql.connector

def getCompanyName():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    file.close()
    return lines[0].strip().lower()

def get_employee_timescales_to_monitor():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    file.close()
    times = []
    ts = lines[3].strip().split("__")
    for time in ts:
        if time != "":
            times.append(time)
    return times


def get_all_kpis():
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=getCompanyName())
    cursor = mydb.cursor()
    get_cmd = str("SELECT kpi_name, target_table FROM kpi_table")
    cursor.execute(get_cmd)
    result = cursor.fetchall()
    kpis = {}
    for r in result:
        kpiname = str(r).split(", ")[0].replace("(", "")
        kpitarget = str(r).split(", ")[1].replace(")", "")
        kpinameam = kpiname.replace("'", "")
        kpitargetam = kpitarget.replace("'", "")
        kpis[kpinameam] = kpitargetam
    cursor.close()
    mydb.close()
    return kpis

def get_performance(user):
    kpis = get_all_kpis()
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=getCompanyName())
    cursor = mydb.cursor()
    timescales = get_employee_timescales_to_monitor()
    usr = user.split("@")[0].strip()
    string_list = []
    for kpi in kpis:
        target_table = kpis[kpi]
        for time in timescales:
            targ = str(time[0].strip()+ "_t")
            done = str(time[0].strip()+ "_d")
            get_cmd = str("SELECT " + done + ", " + targ + " FROM " + target_table + " WHERE user = %s")
            values = (usr,)
            cursor.execute(get_cmd, values)
            result = cursor.fetchone()
            done_res = float(str(result).split(", ")[0].replace("(", ""))
            targ_res = float(str(result).split(", ")[1].replace(")", ""))
            diff = targ_res-done_res
            if diff <= 0:
                diff = 0
            li = str(kpi + ":" + done_res + ":" + targ_res + ":" + done_res + ":" + diff)
            string_list.append(li)
    print (string_list)

def main(args):
    if len(args) == 1:
        get_performance(str(args[0]))
    else:
        print("Error:Not everything was provided")

if __name__ == "__main__":
    main(sys.argv[1:])

