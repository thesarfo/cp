You are given an array of `n` integers with values also in the range `[1, n]` both inclusive. Each integer appears exactly once except `a` which appears twice and `b` which is missing. The task is to find the repeating and missing numbers `a` and `b` where `a` repeats twice and `b` is missing.

For instance, given the array `[3, 1, 2, 5, 3]` the result will be `[3, 4]`

[Leetcode 645](https://leetcode.com/problems/set-mismatch/description/) 

1. **Brute Force Solution**: For each number between 1 to `n`, we will try to count the occurrence in the given array using **linear search**. And the element with occurrence as 2 will be the repeating number and the number with 0 occurrences will be the missing number.

So, we start with a loop from `1` to `n`. For each integer `i`, we will count its occurrence in the given array using linear search. We will store those two elements that have occurrence of `2` and `0`. Finally, we will return the elements.

Below is a code implementation.

```java
public int[] findMissingRepeatingNumbers(int[] arr){
    int n = a.length;
    int repeating = -1, missing = -1;

    for(int i = 1; i <= n; i++){
        int count = 0;
        for(int j = 0; j < n; j++){
            if(arr[j] == i) count++;
        }
        if(count == 2) repeating = i;
        else if(count == 0) missing = i;

        if(repeating != -1 && missing != -1) break;
    }
    int[] ans = {repeating, missing};
    return ans;
}
```

The TC for the above is O(n2)

2. **Better Approach - Hashing**: Instead of counting the occurrences every time, we can use the hashing technique to store the frequency of each element between 1 to `n`. Now, the element with frequency `2` will be the repeating number and the element with frequency `0` will be the missing number.

We can solve this problem using a **hash array**

First, we need a hash array of size `n + 1` since the range of the number is `1 to n`(as we want to store the frequency as well). We will iterate all the elements of the given array and update the hash array accordingly. i.e `hash[a[i]]` = `hash[a[i]] + 1`. Now we will iterate through the hash array and return the two elements with frequencies 2 and 0.

Below is a code implementation

```java
public static int[] findMissingRepeatingNumbers(int[] arr) {
        int n = arr.length; // size of the array
        int[] hash = new int[n + 1]; // hash array

        //update the hash array:
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        //Find the repeating and missing number:
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) repeating = i;
            else if (hash[i] == 0) missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        int[] ans = {repeating, missing};
        return ans;
    }
```

The TC of this is 0(2N) where N = the size of the given array. 


Here’s a refined version of your notes with clearer explanations:

---

3. **Optimal Solution - Using Mathematics**

The idea is to transform the problem into a system of mathematical equations. Given that we need to find two numbers, one missing and one repeating, we can form two linear equations and solve them to find these numbers.

Let:
- `x` be the repeating number.
- `y` be the missing number.

In the input array, the numbers range from `1 to n`. One number is missing (`y`), and one is repeated (`x`).

#### Step 1: Forming Equations
**Equation 1 (Sum of Numbers)**:  
The sum of the first `n` natural numbers is given by the formula:
$$
S_N = \frac{n \times (n + 1)}{2}
$$
Let `s` be the sum of all elements in the input array. Since one number is missing and another is repeated:
$$
S - S_N = x - y \quad \text{(Equation 1)}
$$

**Equation 2 (Sum of Squares of Numbers)**:  
Similarly, the sum of the squares of the first `n` natural numbers is:
$$
S_{2N} = \frac{n \times (n + 1) \times (2n + 1)}{6}
$$
Let `s2` be the sum of the squares of all elements in the array. Again, due to the missing and repeating numbers:
$$
S_2 - S_{2N} = x^2 - y^2 \quad \text{(Equation 2)}
$$

#### Step 2: Solving the Equations
From **Equation 2**, we can factor the right-hand side:
$$
x^2 - y^2 = (x - y)(x + y)
$$
So,
$$
S_2 - S_{2N} = (x - y)(x + y)
$$
From **Equation 1**, we know that `x - y = s - sN`. Let’s substitute this into **Equation 2**:
$$
S_2 - S_{2N} = (S - S_N) \times (x + y)
$$
Now, solve for `x + y`:
$$
x + y = \frac{S_2 - S_{2N}}{S - S_N}
$$

#### Step 3: Finding x and y
Now that we have both:
- $x - y = S - S_N$ (from **Equation 1**)
- $x + y = \frac{S_2 - S_{2N}}{S - S_N}$ (from **Equation 2**)

We can solve for `x` and `y` using substitution:
$$
x = \frac{(x - y) + (x + y)}{2}
$$
$$
y = x - (x - y)
$$

Below is a code implementation

```java
public static int[] findMissingRepeatingNumbers(int[] arr) {
    long n = arr.length;

    // Sum of first n natural numbers
    long SN = (n * (n + 1)) / 2;

    // Sum of squares of first n natural numbers
    long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

    long S = 0, S2 = 0;

    // Calculate sum and sum of squares for the input array
    for (int i = 0; i < n; i++) {
        S += arr[i];
        S2 += (long) arr[i] * (long) arr[i];
    }

    // Calculate the difference between actual and expected sums
    long val1 = S - SN; // x - y
    long val2 = S2 - S2N; // x^2 - y^2

    // Calculate x + y
    val2 = val2 / val1;

    // Calculate x and y
    long x = (val1 + val2) / 2;
    long y = x - val1;

    return new int[] { (int)x, (int)y };
}
```

---

### Key Intuition:
- **`x - y`** comes from the difference between the actual sum and the expected sum of natural numbers.
- **`x + y`** comes from the difference between the actual sum of squares and the expected sum of squares of natural numbers.
- Solving these two equations simultaneously gives us the missing and repeating numbers.

By summing up the numbers and their squares, we reduce the problem to solving these simple linear equations.

