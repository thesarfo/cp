Now lets say you have been given a number `36`, and we want to know the numbers which divide it. By dividing it, i mean
completely dividing it without any remainders. That is what we mean when we talk about `divisors`.

The divisors of `36` are `1, 2, 3, 4, 6, 9, 12, 18, 36`

How do we go about it. First of all, we should keep in mind that all the possible divisors of a given number will be between
`1` and the number itself `n`. This means we can loop from `1` to `n`.

When we initialize this loop, we can basically check if `i` is a divisor of `n` by checking if it divides `n` and leaves a
remainder of `0`. In other words `n % i == 0`.

Below is a sample implementation
```java
    static void printDivisors(int n){

        for (int i = 1; i <= n; i++){
            if (n % i == 0){
                System.out.println(i);
            }
        }
    }
```