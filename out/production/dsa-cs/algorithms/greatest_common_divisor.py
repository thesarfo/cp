'''The best known algorithm for finding a greatest common divisor is Euclids algorithm. Which states that, the greatest common divisor of two integers m and n is n if n divides m evenly.

However, if n does not divide m evenly, then the anser is the greates common divisor of n and the remainder of m divided by n. See below, this implementation of the GCD algorithm only works when the denominator is positive'''


def gcd(m, n):
    while m % n != 0:
        oldm = m
        oldn = n

        m = oldn
        n = oldm % oldn
    return n


print(gcd(20, 10))
