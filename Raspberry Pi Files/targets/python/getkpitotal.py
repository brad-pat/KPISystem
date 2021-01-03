import sys
import mysql.connector

def getCompanyName():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    file.close()
    return lines[0].strip().lower()

def get_kpi_details():
    mydb = mysql.connector.connect(host="0.0.0.0", user="root", passwd="Cloud_Computer", database=getCompanyName())
    cursor = mydb.cursor()
    get_cmd = str("SELECT kpi_name, value, subkpi_table FROM kpi_table")
    cursor.execute(get_cmd)
    result = cursor.fetchall()
    for res in result:
        kpi_name = str(res).split(", ")[0].strip().replace("(", " ").replace("'", "").strip()
        value = str(res).split(", ")[1].strip()
        subkpi_table = str(res).split(", ")[2].strip().replace(")", " ").replace("'", "").strip()
        #print (kpi_name, value, subkpi_table)
        subkpi_cmd = str("SELECT subkpi_name, type, maths, monitor FROM " + subkpi_table)
        cursor.execute(subkpi_cmd)
        skpi_result = cursor.fetchall()
        for sres in skpi_result:
            skpi_name = str(sres).split(", ")[0].replace("(", " ").replace("'", "").strip()
            skpi_type = str(sres).split(", ")[1].replace("'", "").strip()
            skpi_math = str(sres).split(", ")[2].replace("'", "").strip()
            skpi_show = str(sres).split(", ")[3].replace(")", " ").replace("'", "").strip()
            #print (skpi_name, skpi_type, skpi_math, skpi_show)
            show = "false"
            if skpi_show == 1:
                show = "true"
            skpi_string = str(skpi_name + "__" + skpi_type + "__" + skpi_math + "__" + show + "££")
            print (skpi_string)
get_kpi_details()
