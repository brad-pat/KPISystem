def get_store_timescales_to_monitor():
    file = open("/var/www/html/config.txt", "r")
    lines = file.readlines()
    file.close()
    print ("STORETIMES=", lines[2].strip())

get_store_timescales_to_monitor()
