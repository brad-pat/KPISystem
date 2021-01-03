import sys
import mysql.connector
import mysql.connector.errors

def check_user(userid, companyname):
    try:
        mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=companyname.lower().strip())
        cursor = mydb.cursor()
        check_cmd = str("SELECT firstname FROM users WHERE id=%s")
        values = (userid,)
        cursor.execute(check_cmd, values)
        result = cursor.fetchone()
        if result == None:
            print ("CHECKUSER=ERROR:ID NOT FOUND")
        else:
            name = str(result).split(",)")[0].replace("(", " ").replace("'", "").strip()
            print ("CHECKUSER=VALID:", name)
    except (mysql.connector.DatabaseError) as e:
        print ("CHECKUSER=ERROR:", e)

def main(args):
    if len(args) == 2:
        check_user(str(args[0]), str(args[1]))
    else:
        print ("CHECKUSER=ERROR:Arguements")

if __name__ == "__main__":
    main(sys.argv[1:])
