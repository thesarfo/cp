The Greatest Common Divisor simply refers to the highest number that completely divides a group of numbers. Take the numbers `9` and `12` for example.

* Factors of `9`: 1, 3, 9
* Factors of `12`: 1, 2, 3, 4, 6, 12

The common factors between the two are `1` and `3`. Therefore, we can make the conclusion that, the greatest common divisor of `9` and `12` is `3`.

So what we can do is that, we can have a variable `GCD` which will hold our GCD at a given time, and then we loop from `1` to
`n`. At each iteration, we check if the loop index completely divides both numbers.
If it does, we assign it to the `GCD`. We keep doing that till we reach the end of the loop and then we will know our `GCD` answer.

An example implementation could look like this
```java
static int printGcd(int n1, int n2){
    int gcd = 1; // we know for a fact that the gcd of two numbers will always be 1
    for (int i = 1; i < n1; i++){
        if (n1 % i == 0 && n2 % i == 0){
            gcd = i;
        }
    }
    return gcd;
}
```
This is a potential answer. But, note that we looped to `n1`, which is `9`. What if `n1` was `12` and `n2` was `9`. Does
that mean we have to loop from 1 to 12? No. Because we know for a fact that 10, 11, and 12 will not divide 9. So instead of 
looping from 1 to n1 or 1 to n2, we can simply loop from 1 to the minimum of n1 and n2. See below
```java
static int printGcd(int n1, int n2){
    int gcd = 1;
    for (int i = 1; i < Math.min(n1, n2); i++){
        if (n1 % i == 0 && n2 % i == 0){
            gcd = i;
        }
    }
    return gcd;
}
```

Even though the above solutions work, there is an algorithm called **Euclidean Algorithm** which solves this problem but takes a much smaller time to do so.

The Euclidean algorithm states that the `gcd(n1, n2)` is equivalent to the `gcd(n1-n2, n2)` where `n1 > n2.`

So how we approach this is that, when given two numbers, we apply the Euclidean algorithm to make it smaller, keep applying the algorithm to make the numbers smaller, until one of the numbers become `0`. When one of the numbers become `0`, the other number is our GCD. Take the below example

Formula = gcd(n1, n2) -> gcd(n1-n2, n2)
gcd(20, 15) -> gcd(5, 15) // swap n1 with n2
gcd(15, 5) -> gcd(10, 5)
gcd(10, 5) -> gcd(5, 5)
gcd(5, 5) -> gcd(0, 5)

Now that our final number is `(0, 5)`, we can conclude that the gcd of `20, 15` is `5`.

There is a catch here, if we are given a bigger number like `(52, 10)` we might end up not improving the time complexity because it will take a long time to know that `2` is actually the GCD. However, there is another catch here, if we applied the previous Euclidean Algorithm, we would've gotten to a place where we would've gotten `(2, 10)`. But note something here, isn't `(2, 10)` the remainder of `52 / 10`?. Especially the `2`. So can we say that, we can improve this algorithm with the below formula?

`gcd(n1, n2)` is equivalent to the `gcd(n1 % n2, n2)` where `n1 > n2.`

In this formula, we end up skipping a lot of the subtraction steps. And we go on until one of them is `0`, then the other will be our GCD.

```java
while (a > 0 && b > 0){
    if (a > b){
        a = a % b;
    } else{
        b = b % b;
    }
    if (a == 0){
        return b;
    } else{
        return a;
    }
}
