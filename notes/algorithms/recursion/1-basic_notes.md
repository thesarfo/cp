Recursion is a method where a function calls itself to solve smaller instances of the same problem.
Every recursive function must have two parts:

1. **Base case** – a condition where the recursion stops.
2. **Recursive case** – the part where the function calls itself with a smaller or simpler input.

Understanding recursion comes down to recognizing how each call reduces the problem and how the base case eventually stops the chain of calls.



## 1. Printing Something N Times

This is the simplest example of recursion.
We print a name or a message a certain number of times. The function keeps calling itself while decreasing the count until it reaches zero.

```java
void printName(String name, int n) {
    if (n == 0) return; // base case
    System.out.println(name);
    printName(name, n - 1); // recursive call
}
```

The base case prevents infinite recursion. Each recursive call prints once and then moves closer to zero. When `n` is 0, it stops.



## 2. Printing Numbers from 1 to N

In this case, we first print the smaller numbers, then print the current one on the way back up the recursion stack.

```java
void print1ToN(int n) {
    if (n == 0) return;
    print1ToN(n - 1);
    System.out.print(n + " ");
}
```

The recursive call handles the smaller subproblem first (`n-1`), so the numbers appear in increasing order as the function returns.



## 3. Printing Numbers from N to 1

To print in reverse order, print the current number first, then call the function again with one less.

```java
void printNTo1(int n) {
    if (n == 0) return;
    System.out.print(n + " ");
    printNTo1(n - 1);
}
```

This version prints immediately, before the recursive call, which produces a descending sequence.



## 4. Sum of the First N Numbers

The idea is that the sum of the first n numbers equals the current number plus the sum of the numbers before it.

Mathematically:
`sum(n) = n + sum(n - 1)`
and `sum(0) = 0`.

```java
int sum(int n) {
    if (n == 0) return 0;
    return n + sum(n - 1);
}
```

Each call adds `n` to the sum of all smaller numbers until it reaches 0.



## 5. Factorial of N

The factorial of a number is the product of all numbers from 1 up to that number.

Formula: `factorial(n) = n * factorial(n - 1)`
Base case: `factorial(0) = 1`

```java
int factorial(int n) {
    if (n == 0 || n == 1) return 1;
    return n * factorial(n - 1);
}
```

Each call multiplies `n` by the factorial of the previous number until it reaches 1, where recursion stops.



## 6. Reversing an Array

Reversing can also be done recursively by swapping the first and last elements and then calling the function again for the inner part of the array.

```java
void reverse(int[] arr, int start, int end) {
    if (start >= end) return;
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    reverse(arr, start + 1, end - 1);
}
```

The base case occurs when the two indices cross, meaning the array has been completely reversed.



## 7. Checking if a String is a Palindrome

A palindrome reads the same forward and backward.
We compare the first and last characters; if they match, we move inward and repeat.

```java
boolean isPalindrome(String s, int start, int end) {
    if (start >= end) return true;
    if (s.charAt(start) != s.charAt(end)) return false;
    return isPalindrome(s, start + 1, end - 1);
}
```

When all corresponding pairs match until the middle is reached, the string is a palindrome.



## 8. Fibonacci Number

The Fibonacci sequence is defined as
`fib(0) = 0, fib(1) = 1`, and
`fib(n) = fib(n-1) + fib(n-2)` for `n > 1`.

Each term is the sum of the previous two.

```java
int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```

Although this illustrates recursion clearly, it is inefficient for large n because it recomputes values. (This can later be improved with memoization.)



## How to Think Recursively

When approaching a recursion problem, always follow these steps:

1. **Identify the base case.** What is the simplest version of the problem that can be solved directly?
2. **Assume the recursive call works.** Trust that your function correctly handles smaller inputs.
3. **Build the current step.** Use the result from the smaller problem to solve the larger one.
4. **Test with small inputs.** Tracing a small example (like n = 3) helps you understand how calls stack and return.

Recursion becomes easier once you realize that you are breaking a big task into smaller self-similar tasks until you hit the simplest possible one.
