import math

anumber = int(input("Enter a number: "))
'''how to catch errors'''
try:
    print(math.sqrt(anumber))
except:
    print("Bad value for sqrt")
    print("Using absolute value instead")
    print(math.sqrt(abs(anumber)))

if anumber < 0:
    '''we can raise our own runtime error'''
    raise RuntimeError("You cant use a negative number")
else:
    print(math.sqrt(anumber))