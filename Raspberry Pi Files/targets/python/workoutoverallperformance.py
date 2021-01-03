import sys
import mysql.connector

def get_companyname():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    return lines[0].strip().lower()

#UNIVERSAL
def get_kpi_values():
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=get_companyname())
    cursor = mydb.cursor()
    get_cmd = str("SELECT kpi_name, value FROM kpi_table")
    cursor.execute(get_cmd)
    result = cursor.fetchall()
    kpis = {}
    for r in result:
        kpiname = str(r).split(", ")[0].replace("(", "")
        kpivalue = str(r).split(", ")[1].replace(")", "")
        kpinameam = kpiname.replace("'", "")
        kpis[kpinameam] = kpivalue
    cursor.close()
    mydb.close()
    return kpis

#STORE
def workout_difference(kpiname, timescale):
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=get_companyname())
    cursor = mydb.cursor()
    gettargettablecmd = str("SELECT target_table FROM kpi_table WHERE kpi_name=%s")
    values = (kpiname,)
    cursor.execute(gettargettablecmd, values)
    result = cursor.fetchone()
    table = str(result).strip()
    tablen = len(table)-3
    target_table = str(table[2:tablen]).strip()
    time_scale_t = str(timescale[0].strip() + "_t")
    time_scale_d = str(timescale[0].strip() + "_d")
    get_total_target_cmd = str("SELECT SUM(" + time_scale_t + ") AS target_total FROM " + target_table)
    cursor.execute(get_total_target_cmd)
    result_target = cursor.fetchone()
    res_targ = float(str(result_target).split(",)")[0].replace("(", ""))
    get_total_done_cmd = str("SELECT SUM(" + time_scale_d + ") AS done_total FROM " + target_table)
    cursor.execute(get_total_done_cmd)
    result_done = cursor.fetchone()
    res_done = float(str(result_done).split(",)")[0].replace("(", ""))
    cursor.close()
    mydb.close()
    difference = (res_targ-res_done)
    if difference <= 0:
        print ("STOREPERFORMANCEKPI=", round(res_done, 2), "/", round(res_targ, 2), "- 0 To Do")
    else:
        print ("STOREPERFORMANCEKPI=", round(res_done, 2), "/", round(res_targ, 2), "-", round(difference, 2), "To Do")

#STORE
def workout_performance_per_kpi(kpiname, timescale):
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=get_companyname())
    cursor = mydb.cursor()
    gettargettablecmd = str("SELECT target_table FROM kpi_table WHERE kpi_name=%s")
    values = (kpiname,)
    cursor.execute(gettargettablecmd, values)
    result = cursor.fetchone()
    table = str(result).strip()
    tablen = len(table)-3
    target_table = str(table[2:tablen]).strip()
    time_scale_t = str(timescale[0].strip() + "_t")
    time_scale_d = str(timescale[0].strip() + "_d")
    get_total_target_cmd = str("SELECT SUM(" + time_scale_t + ") AS target_total FROM " + target_table)
    cursor.execute(get_total_target_cmd)
    result_target = cursor.fetchone()
    res_targ = float(str(result_target).split(",)")[0].replace("(", ""))
    get_total_done_cmd = str("SELECT SUM(" + time_scale_d + ") AS done_total FROM " + target_table)
    cursor.execute(get_total_done_cmd)
    result_done = cursor.fetchone()
    res_done = float(str(result_done).split(",)")[0].replace("(", ""))
    cursor.close()
    mydb.close()
    print ("STOREPERFORMACEKPI=", round((res_done/res_targ)*100, 3))
    return round((res_done/res_targ)*100, 3)

#STORE
def workout_performance_overall(timescale):
    kpi_values = get_kpi_values()
    values_and_percentages = {}
    for kpi in kpi_values:
        value = kpi_values[kpi]
        percentage = workout_performance_per_kpi(kpi, timescale)
        key = str(kpi + "__"+value)
        values_and_percentages[key] = percentage
    perf = 0
    for value in values_and_percentages:
        done = values_and_percentages[value]
        val = int(value.split("__")[1].strip())
        perff = (done/100)*(val/100)
        perf = perf+perff
    print ("STOREOVERALLPERFORMANCE=", round((perf)*100, 2))

#USER
def workout_performance_per_kpi_user(kpiname, timescale, user):
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=get_companyname())
    cursor = mydb.cursor()
    gettargettablecmd = str("SELECT target_table FROM kpi_table WHERE kpi_name=%s")
    values = (kpiname,)
    cursor.execute(gettargettablecmd, values)
    result = cursor.fetchone()
    table = str(result).strip()
    tablen = len(table)-3
    target_table = str(table[2:tablen]).strip()
    time_scale_t = str(timescale[0].strip() + "_t")
    time_scale_d = str(timescale[0].strip() + "_d")
    usr = user.split("@")[0].strip()
    get_total_target_cmd = str("SELECT "+ time_scale_t + " FROM " + target_table + " WHERE user = %s")
    values = (usr,)
    cursor.execute(get_total_target_cmd, values)
    result_target = cursor.fetchone()
    res_targ = float(str(result_target).split(",)")[0].replace("(", ""))
    get_total_done_cmd = str("SELECT "+ time_scale_d + " FROM " + target_table + " WHERE user = %s") #get_total_done_cmd = str("SELECT SUM(" + time_scale_d + ") AS done_total FROM " + target_table)
    cursor.execute(get_total_done_cmd, values)
    result_done = cursor.fetchone()
    res_done = float(str(result_done).split(",)")[0].replace("(", ""))
    cursor.close()
    mydb.close()
    print ("USERPERFORMANCEKPI=",round((res_done/res_targ)*100, 3))
    return round((res_done/res_targ)*100, 3)

#USER
def workout_difference_user(kpiname, timescale, user):
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=get_companyname())
    cursor = mydb.cursor()
    gettargettablecmd = str("SELECT target_table FROM kpi_table WHERE kpi_name=%s")
    values = (kpiname,)
    cursor.execute(gettargettablecmd, values)
    result = cursor.fetchone()
    table = str(result).strip()
    tablen = len(table)-3
    target_table = str(table[2:tablen]).strip()
    time_scale_t = str(timescale[0].strip() + "_t")
    time_scale_d = str(timescale[0].strip() + "_d")
    usr = user.split("@")[0].strip()
    get_total_target_cmd = str("SELECT "+ time_scale_t + " FROM " + target_table + " WHERE user = %s")
    values = (usr,)
    cursor.execute(get_total_target_cmd, values)
    result_target = cursor.fetchone()
    res_targ = float(str(result_target).split(",)")[0].replace("(", ""))
    get_total_done_cmd = str("SELECT "+ time_scale_d + " FROM " + target_table + " WHERE user = %s") #get_total_done_cmd = str("SELECT SUM(" + time_scale_d + ") AS done_total FROM " + target_table)
    cursor.execute(get_total_done_cmd, values)
    result_done = cursor.fetchone()
    res_done = float(str(result_done).split(",)")[0].replace("(", ""))
    cursor.close()
    mydb.close()
    difference = (res_targ-res_done)
    if difference <= 0:
        print ("USERPERFORMANCEKPI=", round(res_done, 2), "/", round(res_targ, 2), "- 0 To Do")
    else:
        print ("USERPERFORMANCEKPI=", round(res_done, 2), "/", round(res_targ, 2), "-", round(difference, 2), "To Do")

#USER
def workout_performance_overall_user(timescale, user):
    kpi_values = get_kpi_values()
    values_and_percentages = {}
    for kpi in kpi_values:
        value = kpi_values[kpi]
        percentage = workout_performance_per_kpi_user(kpi, timescale, user)
        if percentage != None:
            key = str(kpi + "__"+value)
            values_and_percentages[key] = percentage
    perf = 0
    #print (values_and_percentages)
    for value in values_and_percentages:
        done = values_and_percentages[value]
        val = int(value.split("__")[1].strip())
        #print (val, done)
        perff = (done/100)*(val/100)
        perf = perf+perff
    print ("USEROVERALLPERFORMANCE=", (perf*100))

def dowhat(do, kpiname, timescale, user):
    if do == "performance":
        if kpiname == "ALL":
            if user == "STORE":
                workout_performance_overall(timescale)
            else:
                workout_performance_overall_user(timescale, user)
        else:
            if user == "STORE":
                workout_performance_per_kpi(kpiname, timescale)
            else:
                workout_performance_per_kpi_user(kpiname, timescale, user)
    if do == "difference":
        if user == "STORE":
            workout_difference(kpiname, timescale)
        else:
            workout_difference_user(kpiname, timescale, user)

def main(args):
    if len(args) == 4:
        dowhat(str(args[0]), str(args[1]), str(args[2]), str(args[3]))
    else:
        print ("Error:Arguements error")

if __name__ == "__main__":
    main(sys.argv[1:])
