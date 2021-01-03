import sys
import mysql.connector
import converttarget
import settarget

def getCompanyName():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    file.close()
    return lines[0].strip().lower()

def get_store_timescales_to_monitor():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    file.close()
    times = []
    ts = lines[2].strip().split("__")
    for time in ts:
        if time != "":
            times.append(time)
    return times

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

def get_total_weekly_store_contracted_hours():
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=getCompanyName())
    cursor = mydb.cursor()
    gethourscmd = str("SELECT SUM(cont_hours) AS totalhours FROM users")
    cursor.execute(gethourscmd)
    result = cursor.fetchone()
    hours = str(result).split("'")[1]
    cursor.close()
    mydb.close()
    return int(hours)

def get_total_weekly_store_overtime_hours():
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=getCompanyName())
    cursor = mydb.cursor()
    gethourscmd = str("SELECT SUM(overtime) AS totalhours FROM users")
    cursor.execute(gethourscmd)
    result = cursor.fetchone()
    hours = str(result).split("'")[1]
    cursor.close()
    return int(hours)

def make_weekly_targets_from_weekly_input(overall_target):
    chours = get_total_weekly_store_contracted_hours()
    ohours = get_total_weekly_store_overtime_hours()
    total_hours_in_store = chours+ohours
    hourly_target = overall_target/total_hours_in_store
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=getCompanyName())
    cursor = mydb.cursor()
    get_users_cmd = str("SELECT id FROM users")
    cursor.execute(get_users_cmd)
    result = cursor.fetchall()
    users = []
    usershours = {}
    usertarget = {}
    for r in result:
#        print (r)
        rlen = len(r)-4
        id = str(r)[2:rlen]
 #       print (id)
        users.append(id)
    for u in users:
        get_hours_cmd = str("SELECT cont_hours, overtime FROM users WHERE id=%s")
        values = (u,)
        cursor.execute(get_hours_cmd, values)
        hours = cursor.fetchall()
        for hour in hours:
            #print (hour)
            chour = str(hour).split(", ")[0].replace("(", "")
            ohour = str(hour).split(", ")[1].replace(")", "")
            total_hours = int(chour)+int(ohour)
            usershours[u] = total_hours
    #print (usershours)
    for u in users:
        hours = usershours.get(u)
        target_for_user = hours*hourly_target
        usertarget[u] = target_for_user
    mydb.commit()
    cursor.close()
    mydb.close()
    return usertarget

def convert_target_to_store_scales(target, timescale, timescales):
    targs_conv = {}
    for time in timescales:
        if timescale != time:
        #print (timescale, time, targ)
            convert = converttarget.convert_target(timescale, time, target)
            targs_conv[time] = convert
        #converted = os.system("sudo python3 /var/www/html/targets/python/converttarget.py timescale time targ")
    return targs_conv

def convert_to_weekly_target(timescale, target):
    converted = converttarget.convert_target(timescale, "weekly", target)
    return float(converted)

def convert_indiv_weekly_target_to_scales(timescales, target):
    convertedscales = {}
    for time in timescales:
        if time != "weekly":
            convert = converttarget.convert_target("weekly", time, target)
            convertedscales[time] = convert
    return convertedscales

def workout_target(kpiname, target, timescale):
    storetimes = get_store_timescales_to_monitor()
    employeetimes = get_employee_timescales_to_monitor()
    target_store_times = convert_target_to_store_scales(target, timescale, storetimes)
    store_weekly_target = convert_to_weekly_target(timescale, target)
    indiv_weekly_targets = make_weekly_targets_from_weekly_input(store_weekly_target)
    for user in indiv_weekly_targets:
        user_weekly_target = indiv_weekly_targets[user]
        convertedempscales = convert_indiv_weekly_target_to_scales(employeetimes, user_weekly_target)
        settarget.set_targets(kpiname, "weekly", user_weekly_target, user)
        for time in convertedempscales:
            convert_target = convertedempscales[time]
            settarget.set_targets(kpiname, time, convert_target, user)
    print ("SETTARGETS=Targets Set")

#test = make_weekly_targets_from_weekly_input(500)
#print (test)
#workout_target("new_gsv", 7000, "quarterly")
#convert_target_to_store_scales(5000, "quarterly", get_store_timescales_to_monitor())

def main(args):
    if len(args) == 3:
        workout_target(str(args[0]), float(args[1]), str(args[2]))
    else:
        print("Error:Something went wrong")

if __name__ == "__main__":
    main(sys.argv[1:])
