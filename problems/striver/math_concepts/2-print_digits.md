Lets say you have been given an input number `7789`, and you are asked to extract the digits. In other words, you are asked to print out the individual digits in the input number. How do you go about this.

Now let's analyze this, can we say that when we run `7789 % 10`, we get 9? (i.e the last digit in our input number)? Why is that, if we look at the numbers divisible by 10, (10, 20, 30, 40 etc), we see that these numbers all end with zero(0). Now, a modulo(%) simply  means that, we divide the number by something, and then we return the remainder.

So can we say that when we run `7789 % 10`, the closest number that divides 10 evenly is `7780`, and the remainder is `9`, which is the last digit in our input number.
Now we have gotten the last number `9`, how do we get the second to last number `8`. 

Can we say, that in order to get the number `8`, we can divide `7789/10`...the answer to this is `778.9` - and we are only interest in the integer aspect(`778`). So, in order to get the second to last number, we can divide the input number by 10, and if we need the last digit, we can simply do `778 % 10`, which will give us the `8`. To get the `7`, we will simply divide `778/10`, which is `77.8`, then we run `77 % 10` which is 7. 

We repeat this "divide and modulo" logic until dividing our input number by 10 gives us zero. By that point, we would have already extracted all the last digits in our input number.

Lets look at this logic below in java
```java
static void printDigits(int n){
    while (n > 0){
        int lastDigit = n % 10; // gives us the last digit - remainder
        n = n / 10; // updates our input number to remove the last digit.
    }
}
```