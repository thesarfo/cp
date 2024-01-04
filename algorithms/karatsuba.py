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
