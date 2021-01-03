import sys
import mysql.connector

def getDatabaseName():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    return lines[0].strip().lower()

def add_user_to_target_tables(user):
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=getDatabaseName())
    cursor = mydb.cursor()
    tables_cmd = str("SELECT target_table FROM kpi_table")
    cursor.execute(tables_cmd)
    results = cursor.fetchall()
    tables = []
    uid = user.split("££")[0]
    us = uid.split("@")[0]
    for r in results:
        table = str(r).replace("('", "").replace("',)", "").strip()
        tables.append(table)
    for t in tables:
        cmd = str("INSERT INTO " + t + " (user, d_d, d_t, w_d, w_t, m_d, m_t, q_d, q_t, h_d, h_t, y_d, y_t) VALUES (%s, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)")
        values = (us,)
        cursor.execute(cmd, values)
    mydb.commit()
    cursor.close()
    mydb.close()


def create_user(user):
    databasename = getDatabaseName()
    uid = user.split("££")[0]
    firstname = user.split("££")[1]
    surname = user.split("££")[2]
    cont_hours = int(user.split("££")[3])
    overtime = int(user.split("££")[4])
    role = user.split("££")[5]
    manager = False
    if user.split("££")[6].lower() == "true":
        manager = True
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=databasename)
    cursor = mydb.cursor()
    command = str("INSERT INTO users (id, firstname, surname, cont_hours, overtime, role, manager) VALUES (%s, %s, %s, %s, %s, %s, %s)")
    values = (uid, firstname, surname, cont_hours, overtime, role, manager)
    cursor.execute(command, values)
    mydb.commit()
    cursor.close()
    mydb.close()
    add_user_to_target_tables(user)
    print("COMPLETE:User inserted")

def main(args):
    if len(args) == 1:
        create_user(str(args[0]))
        #getDatabaseName()
    else:
        print("ERROR:Too many or too little details, only 1 arguement")

if __name__ == "__main__":
    main(sys.argv[1:])
