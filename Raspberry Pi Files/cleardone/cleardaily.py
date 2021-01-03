import sys
import mysql.connector

def getCompanyName():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    return lines[0].strip().lower()


def get_all_kpis():
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=getCompanyName())
    cursor = mydb.cursor()
    get_cmd = str("SELECT kpi_name, target_table FROM kpi_table")
    cursor.execute(get_cmd)
    result = cursor.fetchall()
    kpis = []
    for r in result:
        kpiname = str(r).split(", ")[0].replace("(", "")
        kpitarget = str(r).split(", ")[1].replace(")", "")
        kpinameam = kpiname.replace("'", "")
        kpitargetam = kpitarget.replace("'", "")
        kpis.append(kpitargetam)
    cursor.close()
    mydb.close()
    return kpis

def get_all_users():
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=getCompanyName())
    cursor = mydb.cursor()
    get_cmd = str("SELECT id FROM users")
    cursor.execute(get_cmd)
    result = cursor.fetchall()
    usrs = []
    for r in result:
        email = str(r).split(",)")[0].replace("(", "")
        id = email.split("@")[0].replace("'", "")
        usrs.append(id)
    cursor.close()
    mydb.close()
    return usrs


def set_targets():
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=get_companyname())
    cursor = mydb.cursor()
    kpis = get_all_kpis()
    users = get_all_users()
    for kpi in kpis:
        for u in users:
            cmd = str("UPDATE " + kpi + " SET d_d = 0 WHERE user = %s")
            values = (u,)
            cursor.execute(cmd, values)
    mydb.commit()
    cursor.close()
    mydb.close()

set_targets()
