import sys
import mysql.connector

def getDatabaseName():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    return lines[0].strip().lower()

def delete_user_from_target_tables(uid):
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=getDatabaseName())
    cursor = mydb.cursor()
    tables_cmd = str("SELECT target_table FROM kpi_table")
    cursor.execute(tables_cmd)
    results = cursor.fetchall()
    tables = []
    us = uid.split("@")[0]
    for r in results:
        table = str(r).replace("('", "").replace("',)", "").strip()
        tables.append(table)
    for t in tables:
        cmd = str("DELETE FROM " + t + " WHERE user= %s")
        values = (us,)
        cursor.execute(cmd, values)
    cursor.close()
    mydb.close()



def delete_user(userid):
    databasename = getDatabaseName()
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=databasename)
    cursor = mydb.cursor()
    cmd = str("DELETE FROM users WHERE id= %s")
    print(userid)
    val = (userid.strip().lower(),)
    cursor.execute(cmd, val)
    mydb.commit()
    cursor.close()
    mydb.close()
    delete_user_from_target_tables(userid)

def main(args):
    if len(args) == 1:
        delete_user(str(args[0]))
    else:
        print("ERROR:Too man or little details, only 1 arguement")

if __name__ == "__main__":
    main(sys.argv[1:])
