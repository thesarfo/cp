An armstrong number is a number where, adding the cube of all its individual digits add up to the number itself.

Take a number like `371` for instance, adding 3cube + 9cube + 1cube sums up to `371` itself. Hence, this number is an armstrong number.

Now, we already know how to extract individual digits from a number, so we can use that same algorithm to solve the problem, 
just that we have to calculate the cube of each individual number.

So, using the logic of the extract digits, we can basically initialize a variable called sum, and then we reassign sum
to sum plus the last digit(the individual digit we want to cube) cubed. Then, later we can compare sum to check if it is equal
to the original input number.
A sample implementation will look like this.

```java
static void armstrong(int n){
    int duplicate = n; // store the input number in this duplicate variable since n will change on each iteration
    int sum = 0;
    while (n > 0){
        int lastDigit = n % 10;
        sum = sum + (lastDigit * lastDigit * lastDigit); // each digit cubed will be stored into sum
        n = n / 10;
    }
    if ( sum == duplicate){
        return "true";
    } else{
        return "false";
    }
}
```