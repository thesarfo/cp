import math
from math import log10

def karatsuba(x, y):

    #base case for recursion
    if x < 10 or y < 10:
        return x*y

    n = max(int(log10(x)+1), int(log10(y)+1))

    n_2 = int(math.ceil(n / 2.0))
    n = n if n % 2 == 0 else n + 1

    a, b = divmod(x, 10**n_2)
    c, d = divmod(y, 10**n_2)

    #applies the three recursive steps
    ac = karatsuba(a,c)
    bd = karatsuba(b,d)
    ad_bc = karatsuba((a+b),(c+d)) - ac - bd
    
    #performs the multiplication
    return (((10**n)*ac) + bd + ((10**n_2)*(ad_bc)))

# test cases
test = karatsuba(5664354, 48484848484)
test1 = karatsuba(847392, 32478)
test2 = karatsuba(736, 842)
test3 = karatsuba(33, 10)
test4 = karatsuba(263, 3664)

print(test)
print(test1)
print(test2)
print(test3)
print(test4)