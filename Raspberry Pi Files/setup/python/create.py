import sys
import mysql.connector
import logging

logging.debug('debug')
logging.info('info')
logging.warning('warning')
logging.error('error')
logging.critical('critical')

companyname = ""
trackingtype = ""
trackstore = False
trackemployee = False
users_list = []
kpis_list = []
storetimescales = []
employeetimescales = []
kpistring = ""

def setup_system(general, users, kpis, other):
    global companyname
    global trackingtype
    global trackstore
    global trackemployee
    global users_list
    global kpis_list
    global storetimescales
    global employeetimescales
    global kpistring
    kpistring = kpis
    companyname = general.split('££')[0]
    trackingtype = general.split('££')[1]
    if general.split('££')[2].lower() == "true":
        trackstore = True
    if general.split('££')[3].lower() == "true":
        trackemployee = True
    usrs = users.split('???')
    for u in usrs:
        users_list.append(u)
    kps = kpis.split('???')
    for k in kps:
        kpis_list.append(k)
    stracks = other.split('ZQZ')[0]
    stk = stracks.split('££')
    for s in stk:
        storetimescales.append(s)
    etracks = other.split('ZQZ')[1]
    etk = etracks.split('££')
    for e in etk:
        employeetimescales.append(e)

def create_database():
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer")
    command = str("CREATE DATABASE " + companyname.lower() + ";")
    cursor = mydb.cursor()
    cursor.execute(command)
    mydb.commit()
    cursor.close()
    mydb.close()

def setup_file_handler():
    text_file = open("/var/www/html/config.txt", "w")
    lines = [companyname, "\n", trackingtype, "\n"]
    for time in storetimescales:
        lines.append(time)
        lines.append("__")
    lines.append("\n")
    for time in employeetimescales:
        lines.append(time)
        lines.append("__")
    lines.append("\n")
    lines.append(kpistring)
    text_file.writelines(lines)
    text_file.close()

def setup_users():
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=companyname.lower())
    cursor = mydb.cursor()
    create_cmd = "CREATE TABLE users (id VARCHAR(64), firstname VARCHAR(64), surname VARCHAR(64), cont_hours INT, overtime INT, role VARCHAR(32), manager BOOL)"
    cursor.execute(create_cmd)
    for user in users_list:
        uid = user.split("££")[0]
        fname = user.split("££")[1]
        sname = user.split("££")[2]
        cont_hours = int(user.split("££")[3])
        overtime = int(user.split("££")[4])
        role = user.split("££")[5]
        manager = False
        if user.split("££")[6].lower() == "true":
            manager = True
        insert_cmd = "INSERT INTO users (id, firstname, surname, cont_hours, overtime, role, manager) VALUES (%s, %s, %s, %s, %s, %s, %s)"
        values = (uid, fname, sname, cont_hours, overtime, role, manager)
        cursor.execute(insert_cmd, values)
    mydb.commit()
    cursor.close()
    mydb.close()

def setup_kpis():
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=companyname.lower())
    cursor = mydb.cursor()
    create_cmd = "CREATE TABLE kpi_table (kpi_name VARCHAR(64), value INT, type VARCHAR(8), subkpi_table VARCHAR(32), target_table VARCHAR(32))"
    cursor.execute(create_cmd)
    for kpi in kpis_list:
        kpi_name = kpi.split("££")[0]
        value = int(kpi.split("££")[1])
        type = kpi.split("££")[2]
        subkpidata = kpi.split("££")[3]
        subkpis = []
        subkpi_shows = []
        for skpi in subkpidata.split("@@@"):
            subkpis.append(skpi)
        subtablename = str(kpi_name + "_subkpis")
        targettablename = str(kpi_name + "_targets")
        add_kpitable_cmd = "INSERT INTO kpi_table (kpi_name, value, type, subkpi_table, target_table) VALUES (%s, %s, %s, %s, %s)"
        kpi_values = (kpi_name, value, type, subtablename, targettablename)
        cursor.execute(add_kpitable_cmd, kpi_values)
        create_subkpi_table_cmd = str("CREATE TABLE " +  subtablename + " (subkpi_name VARCHAR(32), type VARCHAR(8), maths VARCHAR(8), monitor BOOL, target_table VARCHAR(128))")
        cursor.execute(create_subkpi_table_cmd)
        for skpi in subkpis:
            skpi_name = skpi.split("ZQZ")[0]
            skpi_type = skpi.split("ZQZ")[1]
            skpi_math = skpi.split("ZQZ")[2]
            skpi_show = False
            showtablename = ""
            if skpi.split("ZQZ")[3].lower() == "true":
                skpi_show = True
                showtablename = str(kpi_name + "_" + skpi_name + "_targets")
                subkpi_shows.append(showtablename)
            add_subkpi_table_cmd = str("INSERT INTO " + subtablename + " (subkpi_name, type, maths, monitor, target_table) VALUES (%s, %s, %s, %s, %s)")
            skpi_values = (skpi_name, skpi_type, skpi_math, skpi_show, showtablename)
            cursor.execute(add_subkpi_table_cmd, skpi_values)
        create_target_table_cmd = str("CREATE TABLE " + kpi_name + "_targets (user VARCHAR(64), d_d DOUBLE, d_t DOUBLE, w_d DOUBLE, w_t DOUBLE, m_d DOUBLE, m_t DOUBLE, q_d DOUBLE, q_t DOUBLE, h_d DOUBLE, h_t DOUBLE, y_d DOUBLE, y_t DOUBLE)")
        cursor.execute(create_target_table_cmd)
        for user in users_list:
            uid = user.split("££")[0]
            uuid = uid.split("@")[0]
            add_users_to_target_cd = str("INSERT INTO " + kpi_name + "_targets (user, d_d, d_t, w_d, w_t, m_d, m_t, q_d, q_t, h_d, h_t, y_d, y_t) VALUES (\'" + uuid + "\', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)")
            cursor.execute(add_users_to_target_cd)
            for time in employeetimescales:
                t = time[0]
                upd_cmd = str("UPDATE " + kpi_name + "_targets SET " + t + "_d = 0, " + t + "_t = 0 WHERE user = %s")
                values = (uuid,)
                cursor.execute(upd_cmd, values)
        if len(subkpi_shows) != 0:
            for subk in subkpi_shows:
                create_subk_table_cmd = str("CREATE TABLE " + subk + " (user VARCHAR(64), d_d DOUBLE, d_t DOUBLE, w_d DOUBLE, w_t DOUBLE, m_d DOUBLE, m_t DOUBLE, q_d DOUBLE, q_t DOUBLE, h_d DOUBLE, h_t DOUBLE, y_d DOUBLE, y_t DOUBLE)")
                cursor.execute(create_subk_table_cmd)
                for user in users_list:
                    uid = user.split("££")[0]
                    add_users_to_subkpi_cmd = str("INSERT INTO " + subk + " (user, d_d, d_t, w_d, w_t, m_d, m_t, q_d, q_t, h_d, h_t, y_d, y_t) VALUES (\'" + uuid + "\', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)")
                    cursor.execute(add_users_to_subkpi_cmd)
                    for time in employeetimescales:
                        t = time[0]
                        upd_cmd = str("UPDATE " + kpi_name + "_targets SET " + t + "_d = 0, " + t + "_t = 0 WHERE user = %s")
                        values = (uuid,)
                        cursor.execute(upd_cmd, values)

    mydb.commit()
    cursor.close()
    mydb.close()

def main(args):
    if len(args) == 4:
        setup_system(str(args[0]), str(args[1]), str(args[2]), str(args[3]))
        create_database()
        setup_file_handler()
        setup_users()
        setup_kpis()
        print("Complete:Setup")
    else:
        print("Error:Not everything was provided")

if __name__ == "__main__":
    main(sys.argv[1:])
