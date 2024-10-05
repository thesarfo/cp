A prime number is a number that has exactly two factors -> 1 and itself. We know how to derive the factors of a given number. So let's look at this problem in a brute force way. 

* We can initialize a counter and set it to `0`
* And then we loop from `1` to the number.
* On each iteration, we check if the number and the loop index are a complete division.
* If they are, we increment the counter by `1`
* After the loop, if the counter variable is equal to `2`, we know the input number is a prime number. Otherwise, it's not.

This is the code for the above algorithm
```java
static boolean checkPrime(int n){
    int count = 0;
    for (int i = 1; i <= n; i++){
        if (n % i == 0){
            count ++;
        }
    }
    return count == 2;
}
```
This solution is clearly inefficient especially for larger numbers. The key observation here that allows for optimization is that factors come in pairs. For example, if a is a factor of n, then n/a is also a factor of n.

Therefore, we can check from 1 to sqrt(n)

#### Why check up to sqrt(n).
1. **Factor Pairs**: For a number n, if you find a factor a such that n mod a = 0(i.e a divides n evenly), then b = n/a is also a factor.
2. **Symmetry**: The factors of n are symmetric around sqrt(n). This means that if n = a * b, then one of the factors a or b will be less than or equal to sqrt(n) and the other will be greater than or equal to sqrt(n), you automatically get its corresponding pair factor which is greater than sqrt(n).

For example,
- if n = 36, its factors are 1, 2, 3, 4, 6, 9, 12, 18, 36
- if you only check up to sqrt(36) = 6, you find 1, 2, 3, 4, 6. For each of these factors, you can get the corresponding pair factor: 36/1, 36/2, 36/3, 36/4, 36/6, which gives 36, 18, 12, 9, 6. Hence, you get all the factors.

Therefore, the above code can be optimized as follows
```java
static boolean checkPrime(int n){
    int count = 0;
    for (int i = 1; i <= n; i++){
        if (n % 1 == 0){
            count++;
            if((n/1) != i) count++;
        }
    }
    if(count == 2){
        return true;
    } else{
        return false;
    }
}
```
