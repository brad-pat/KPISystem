import sys
import mysql.connector

def get_companyname():
    f = open("/var/www/html/config.txt", "r")
    lines = f.readlines()
    f.close()
    return lines[0].strip().lower()

def get_store_times():
    f = open("/var/www/html/config.txt", "r")
    lines = f.readlines()
    f.close()
    times = []
    toformat = lines[2].strip().lower().split("__")
    for t in toformat:
        if t != "":
            times.append(t)
    counter = 1
    store_str = ""
    for t in times:
        if counter != len(times):
            store_str+=t+"XX"
        else:
            store_str+=t
        counter+=1
    return store_str

def get_employee_times():
    f = open("/var/www/html/config.txt", "r")
    lines = f.readlines()
    f.close()
    times = []
    toformat = lines[3].strip().lower().split("__")
    for t in toformat:
        if t != "":
            times.append(t)
    counter = 1
    store_str = ""
    for t in times:
        if counter != len(times):
            store_str+=t+"XX"
        else:
            store_str+=t
        counter+=1
    return store_str

def create_user_string():
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=get_companyname())
    cursor = mydb.cursor()
    cmd = str("SELECT * FROM users")
    cursor.execute(cmd)
    results = cursor.fetchall()
    users = []
    for r in results:
        user_parts = str(r).split(", ")
        email = user_parts[0].replace("\'", "").replace("(", "").strip()
        firstname = user_parts[1].replace("'", "").strip()
        lastname = user_parts[2].replace("'", "").strip()
        cont_hours = int(user_parts[3].strip())
        overtime = int(user_parts[4].strip())
        role = user_parts[5].replace("'", "").strip()
        manager = "false"
        if int(user_parts[6].replace(")", "").strip()) == 1:
            manager = "true"
        #print (email, firstname, lastname, cont_hours, overtime, role, manager)
        user_str = str(email + "XX" + firstname + "XX" + lastname + "XX" + str(cont_hours) + "XX" + str(overtime) + "XX" + role + "XX" + manager)
        users.append(user_str)
    counter = 1
    usr_str = ""
    for u in users:
        #print (counter, len(users))
        if counter != len(users):
            usr_str+=u+"???"
        else:
            usr_str+=u
        counter+=1
    cursor.close()
    mydb.close()
    return usr_str

def create_kpi_string():
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=get_companyname())
    cursor = mydb.cursor()
    cmd = str("SELECT * FROM kpi_table")
    cursor.execute(cmd)
    results = cursor.fetchall()
    kpis = []
    for r in results:
        kpi_parts = str(r).split(", ")
        kpi_name = kpi_parts[0].replace("(\'", "").replace("'", "").strip()
        value = kpi_parts[1].strip()
        type = kpi_parts[2].replace("'", "").strip()
        subkpi_table = kpi_parts[3].replace("'", "").strip()
        #print (kpi_name, value, type)
        s_cmd = str("SELECT * FROM " + subkpi_table)
        cursor.execute(s_cmd)
        skpi_results = cursor.fetchall()
        skpi_list = []
        for sr in skpi_results:
            skpi_parts = str(sr).split(", ")
            skpi_name = skpi_parts[0].replace("(", "").replace("'", "").strip()
            skpi_type = skpi_parts[1].replace("'", "").strip()
            skpi_maths = skpi_parts[2].replace("'", "").strip()
            skpi_show = "false"
            if int(skpi_parts[3]) == 1:
                skpi_show = "true"
            #print (skpi_name, skpi_type, skpi_maths, skpi_show)
            skpi_str = str(skpi_name+"ZQZ"+skpi_type+"ZQZ"+skpi_maths+"ZQZ"+skpi_show)
            skpi_list.append(skpi_str)
        skpi_counter = 1
        skpi_string = ""
        for skpi in skpi_list:
             #print (skpi_counter, len(skpi_list))
             if skpi_counter != len(skpi_list):
                 skpi_string+=skpi+"!!!"
             else:
                 skpi_string+=skpi
             skpi_counter+=1
        kpi_str = str(kpi_name+"XX"+value+"XX"+type+"XX"+skpi_string)
        kpis.append(kpi_str)
    kpi_string = ""
    counter = 1
    for k in kpis:
        if counter != len(kpis):
            kpi_string+=k+"???"
        else:
            kpi_string+=k
        counter+=1
    cursor.close()
    mydb.close()
    return kpi_string


def main():
    users = create_user_string()
    kpis = create_kpi_string()
    store_times = get_store_times()
    employee_times = get_employee_times()
    print ("SETUPSYSTEM=", users, "QQQ", kpis, "QQQ", store_times, "QQQ", employee_times,  sep='')


main()
