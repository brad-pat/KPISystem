import sys
import mysql.connector

def get_companyname():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
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

def all_timescales():
    stores = get_store_timescales_to_monitor()
    employees = get_employee_timescales_to_monitor()
    final_list = []
    for t in stores:
        final_list.append(t)
    for t in employees:
        if t not in final_list:
            final_list.append(t)
    return final_list

def maths_parser(input, maths):
    operator = maths[0]
    do = float(maths[1:])
    if operator == "+":
        return input+do
    if operator == "-":
        return input-do
    if operator == "*":
        return input*do
    if operator == "/":
        return input/do
    else:
        return input

def process_sale(kpiname, subkpi, sale, user):
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=get_companyname())
    cursor = mydb.cursor()
    get_maths_cmd = str("SELECT maths FROM "+ kpiname + "_subkpis WHERE subkpi_name = %s")
    values = (subkpi,)
    cursor.execute(get_maths_cmd, values)
    result = cursor.fetchone()
    maths = str(result).split(",)")[0].replace("(", " ").replace("'", "").strip()
    sale_total = maths_parser(sale, maths)
    time_scales = all_timescales()
    usr = user.split("@")[0]
    for time in time_scales:
        t = time[0]
        get_current_cmd = str("SELECT " + t + "_d FROM " + kpiname + "_targets WHERE user = %s")
        values = (usr,)
        cursor.execute(get_current_cmd, values)
        result = cursor.fetchone()
        current = str(result).split(",)")[0].replace("(", "")
        if current == "None":
            current = 0
        new_input = (float(current)+float(sale_total))
        update_cmd = str("UPDATE " + kpiname + "_targets SET " + t + "_d = %s WHERE user = %s")
        values = (new_input, usr)
        cursor.execute(update_cmd, values)
    mydb.commit()
    cursor.close()
    mydb.close()
    print ("PROCESSSALE=SUCCESS")

def main(args):
    if len(args) == 4:
        process_sale(str(args[0]), str(args[1]), float(args[2]), str(args[3]))
    else:
        print ("ERROR: Arguments")

if __name__ == "__main__":
    main(sys.argv[1:])
