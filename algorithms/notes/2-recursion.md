Recursion is particularly useful for divide and conquer problems; however, it can be difficult to understand exactly what is happening, since each recursive call is itself spinning off other recursive calls. At the core of a recursive function are two types of cases: base cases, which tell the recursion when to terminate, and recursive cases that call the function they are in. A simple problem that naturally lends itself to a recursive solution is calculating factorials. The recursive factorial algorithm defines two cases: the base case when n is zero, and the recursive case when n is greater than zero. A typical implementation is the following

```python
def factorial(n):
    #test for a base case
    if n == 0:
        return 1
    else:
        # make a calculation and a recursive call
        f = n * factorial(n - 1)
        print(f) #print intermediate results (optional)
        return (f)
```

## How recursion works
Let's say we are tasked to print a number from 1 to n using recursion. Below is how the code would look like;
```python
def more(n):
    if n < 1: # base case
        return
    more(n - 1)
    print(n)

more(3)
```

First of all, note how we check if `n < 1` and then we return / exit execution of the function. This is called a base case. Normally, a recursion call lasts forever until a stack overflow/segfault occurs. In order to prevent this, we add a base case to terminate the recursive calls. Now the above function prints "1, 2, 3". 

When we call the function `more(3)`:
1. We check if the base case is true -> it is not since `3 > 1`
2. We call the function itself with a decrement of n. This calls the same function again in the recursive tree. So the function `more(3)` hasn't stopped executing.
3. We go to the 2nd function `more(3 - 1)`, check for the base case and recall the same function in the recursive tree. 
4. We keep doing that until the base case becomes true, only then do we return/break the functions executions...therefore printing `n` on each function exit.

This is how the recursive call looks like visually
<br>
<img src="../images/recursion.png">
<br>

This is the basic idea of how recursion works

#### We can use the above logic to solve a bunch of recursion problems

1. Print the word "GFG" n times using recursion.
```java
class Solution {

    void printGfg(int N) {
        if (N < 1) return;
        
        printGfg(N - 1);
        System.out.print("GFG ");
    }
}
```

2. Print the numbers from n to 1 using recursion
```python
def more(n):
    if n < 1: # base case
        return
    print(n) # print n first to do it in decrementing order
    more(n - 1)

more(3)
```

3. Print the sum of the first n numbers
For instance, when n = 3...the first 3 numbers of 6 are 1, 2, 3...therefore 1 + 2 + 3 = 6.

There are two ways to solve this problem, one using the parameterized recursion and the other using functional recursion.

**Parameterized way(a function with parameters)**
The below function prints the sum of numbers from 1 to n.
```java
function(i, sum){
    if (i < 1){ // base case
        print(sum);
        return;
    }
    function(i - 1, sum + 1);
}
```

Assuming the function call was `function(3, 0)`, we go through the function, the base case does not execute, and the recursive function executes with `function(2, 1)`, this function calls another function, and as time goes on, the value of `i` keeps decrementing by 1 as the value of `sum` keeps incrementing by 1. It goes on until our base case is reached, and then we print the sum.

**Functional way(using a direct recursive function)**
```java
function(n){
    if (n == 0){
        return 0;
    }
    return n + function(n - 1);
}
```
Same thing, if this function is called with `function(3)`, the base case does not execute, and the recursive function executes with `3 + function(2)`, which calls another function, all the way until it reaches the base case. When the base case gets executed, it returns a value 0, that 0, replaces the last recursive call that met the base case i.e `return 1 + function(0)`, becomes `return 1 + 0` and this goes up the recursion tree until it reaches the first function. Then the value gets returned.

This idea can be extended to find the `factorial` of a number where `factorial(3) = 1 * 2 * 3`. It's the same idea as the above, just that it's multiplication instead of addition. And the base case will change, because if our base case returns `0`, the overall product becomes 0 as well since everything multiplied by 0 is 0
```java
factorial(n){
    if (n == 0){
        return 1;
    }
    return n * factorial(n - 1);
}