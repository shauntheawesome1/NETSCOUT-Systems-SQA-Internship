import subprocess

arg1 = input("First Octet : ")
arg2 = input("Second Octet : ")
arg3 = input("Third Octet : ")

a = str(arg1)
b = str(arg2)
c = str(arg3)

for i in range(2, 10):
    stringi = str(i)
    pingNumber = 'ping -n 1 ' + a + "." + b + "." + c + "." + stringi
    file = open("temporary.txt", "w")
    subprocess.call(pingNumber, shell=True, stdout=file)
    file.close()
    file = open("temporary.txt", "r")
    text = file.read()
    print(text)
    s = "Request timed out." #JetBrains Unreachable code
    p = "Destination Host Unreachable." # PuTTy/Linux Unreachable code
    if s in text or p in text:
        f = open("ipFile2.txt", mode="a+")
        f.write("" + a + "." + b + "." + c + "." + stringi)
        f.write("\n")
