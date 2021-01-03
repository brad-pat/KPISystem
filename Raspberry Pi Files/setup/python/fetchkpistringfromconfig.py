def read_file():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    file.close()
    toprint = lines[4].replace("???", "ZZZQQQ").replace("££", "QPQPQ")
    print ("KPISTRING=", toprint, sep='')

read_file()
