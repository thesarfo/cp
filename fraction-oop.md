```python
class Fraction:
    def __init__(self, top, bottom):
        self.num = top
        self.den = bottom

    def __str__(self):
        return str(self.num) + "/" + str(self.den)

    def __add__(self, otherfraction):
        newnum = self.num * otherfraction.den + self.den * otherfraction.num
        newden = self.den * otherfraction.den
        common = gcd(newnum, newden)
        return Fraction(newnum // common, newden // common)

    def __eq__(self, other):
        firstnum = self.num * other.den
        secondnum = other.num * self.den
        return firstnum == secondnum

def gcd(m, n):
    while m % n != 0:
        oldm = m
        oldn = n
        m = oldn
        n = oldm % oldn
    return n

x = Fraction(1, 2)
y = Fraction(2, 3)
print(x + y)
print(x == y)
```

## Explanation
1. **Class Definition**: The Fraction class is defined to represent fractions. This class will provide methods to perform operations on fractions.

2. **Constructor (`__init__`)**: The constructor method initializes a Fraction object with two parameters: `top` (numerator) and `bottom` (denominator). It assigns these values to instance variables `num` and `den` respectively.

3. **String Representation (`__str__`)**: This method returns a string representation of a Fraction object in the form `"numerator/denominator"`.

4. **Addition (`__add__`)**: This method overrides the addition operator `+` for Fraction objects. It computes the sum of two fractions by finding a common denominator, adding the numerators, and then reducing the resulting fraction to its simplest form.

5. **Equality Comparison (`__eq__`)**: This method overrides the equality operator `==` for Fraction objects. It compares two fractions to check if they are equal by cross-multiplying and comparing the results.

6. **Greatest Common Divisor (`gcd`)**: This function calculates the greatest common divisor (GCD) of two integers using Euclid's algorithm. It's used in the Fraction class to reduce fractions to their simplest form.

7. **Example Usage**: An example usage of the Fraction class is provided where two Fraction objects `x` and `y` are created with values 1/2 and 2/3 respectively. Then, the addition of `x` and `y` is printed, followed by checking if `x` is equal to `y`.

This implementation demonstrates the creation of Fraction objects, addition of fractions, and comparison of fractions for equality, all while ensuring the fractions are in their simplest form.


This is how the multiplication, division and subtraction methods will be implemented
```python
    def __mul__(self, other):
        newnum = self.num * other.num
        newden = self.den * other.den
        common = gcd(newnum, newden)
        return Fraction(newnum // common, newden // common)

    def __sub__(self, otherfraction):
        newnum = self.num * otherfraction.den - self.den * otherfraction.num
        newden = self.den * otherfraction.den
        common = gcd(newnum, newden)
        return Fraction(newnum // common, newden // common)

    def __truediv__(self, otherfraction):
        newnum = self.num * otherfraction.den
        newden = self.den * otherfraction.num
        common = gcd(newnum, newden)
        return Fraction(newnum // common, newden // common)
```