import sys

def from_year(to, target):
    if to.lower() == "daily":
        return float(target/365)
    if to.lower() == "weekly":
        return float(target/52)
    if to.lower() == "monthly":
        return float(target/12)
    if to.lower() == "quarterly":
        return float(target/4)
    if to.lower() == "halfly":
        return float(target/2)

def from_half(to, target):
    if to.lower() == "daily":
        return float(target/182)
    if to.lower() == "weekly":
        return float(target/26)
    if to.lower() == "monthly":
        return float(target/6)
    if to.lower() == "quarterly":
        return float(target/2)
    if to.lower() == "yearly":
        return float(target*2)

def from_quarter(to, target):
    if to.lower() == "daily":
        return float(target/90)
    if to.lower() == "weekly":
        return float(target/13)
    if to.lower() == "monthly":
        return float(target/3)
    if to.lower() == "halfly":
        return float(target*2)
    if to.lower() == "yearly":
        return float(target*4)

def from_month(to, target):
    if to.lower() == "daily":
        return float(target/30)
    if to.lower() == "weekly":
        return float(target/4)
    if to.lower() == "quarterly":
        return float(target*3)
    if to.lower() == "halfly":
        return float(target*6)
    if to.lower() == "yearly":
        return float(target*12)

def from_week(to, target):
    if to.lower() == "daily":
        return float(target/7)
    if to.lower() == "monthly":
        return float(target*4)
    if to.lower() == "quarterly":
        return float(target*13)
    if to.lower() == "halfly":
        return float(target*26)
    if to.lower() == "yearly":
        return float(target*52)

def from_daily(to, target):
    if to.lower() == "monthly":
        return float(target*30)
    if to.lower() == "weekly":
        return float(target*7)
    if to.lower() == "quarterly":
        return float(target*90)
    if to.lower() == "halfly":
        return float(target*182)
    if to.lower() == "yearly":
        return float(target*365)

def convert_target(from_target, to_target, target):
    if from_target.lower().strip() == "daily":
        t = from_daily(to_target(), target)
        return t
    if from_target.lower().strip() == "weekly":
        t = from_week(to_target, target)
        return t
    if from_target.lower().strip() == "monthly":
        t = from_month(to_target, target)
        return t
    if from_target.lower().strip() == "quarterly":
        t = from_quarter(to_target, target)
        return t
    if from_target.lower().strip() == "halfly":
        t = from_half(to_target, target)
        return t
    if from_target.lower().strip() == "yearly":
        t = from_year(to_target, target)
        return t

def main(args):
    if len(args) == 3:
        print(args[0], args[1], args[2])
        converted = convert_target(str(args[0]), str(args[1]), float(args[2]))
        print(converted)
    else:
        print("Incorrect Arguements")

if __name__ == "__main__":
    main(sys.argv[1:])
