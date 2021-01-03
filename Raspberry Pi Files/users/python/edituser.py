import sys
import mysql.connector

def getDatabaseName():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    return lines[0].strip().lower()

def edituser(user):
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
    cmd = str("UPDATE users SET firstname = %s, surname = %s, cont_hours = %s, overtime = %s, role = %s, manager = %s WHERE id = %s")
    values = (firstname, surname, cont_hours, overtime, role, manager, uid)
    cursor.execute(cmd, values)
    mydb.commit()
    cursor.close()
    mydb.close()

def main(args):
    if len(args) == 1:
        edituser(str(args[0]))
    else:
        print("ERROR:Too many or too little details")

if __name__ == "__main__":
    main(sys.argv[1:])
