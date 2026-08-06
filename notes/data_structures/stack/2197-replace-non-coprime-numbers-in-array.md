Given an array of positive integers, repeatedly find adjacent pairs that are **not coprime** (their GCD > 1) and replace both with their **LCM**. Keep doing this until no two adjacent elements are non-coprime, then return the final array.

Two numbers are **coprime** if their GCD is 1. Replacing `a` and `b` with `lcm(a, b)` collapses them into one number.

[Leetcode 2197](https://leetcode.com/problems/replace-non-coprime-numbers-in-array/).

### The key insight

This is a repeated-merging problem with a constraint that looks "local". The natural tool is a **stack**, because merging can cascade: once you replace `(a, b)` with `lcm(a, b)`, the new value might itself be non-coprime with the element sitting to its **left** in the stack, so the merge must keep going.

### Approach

1. Push numbers onto a stack one at a time.
2. After pushing a candidate value, **while** the top of the stack exists and `gcd(top, candidate) > 1`:
   - Pop the top.
   - Replace the candidate with `lcm(candidate, top)`.
   - Loop again: the merged value may collide with the new top.
3. Push the final candidate.
4. The stack built bottom-to-top is the result (reverse the pop order when reading off).

### Why the search direction works

Because replacements only happen between the current element and previous ones, processing left-to-right and resolving collisions against the stack covers every possible merge. When two elements collapse and their result is still non-coprime with the preceding one, the loop keeps folding them together.

### Code Implementation

```java
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Long> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            long cur = num;

            while (!stack.isEmpty()) {
                long top = stack.peek();
                long gcd = findgcd(cur, top);

                if (gcd > 1) {
                    stack.pop();
                    cur = findlcm(cur, top);
                } else {
                    break;
                }
            }
            stack.push(cur);
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop().intValue());
        }
        Collections.reverse(list);

        return list;
    }

    public static long findgcd(long a, long b) {
        if (b == 0) return a;
        return findgcd(b, a % b);
    }

    public static long findlcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs((a / findgcd(a, b)) * b);
    }
}
```

### Complexity

- **Time:** O(n log M), where `M` is the max value (each element is pushed and popped at most once, plus gcd per merge).
- **Space:** O(n) for the stack.

### Conclusion

The stack naturally handles cascading merges: you only ever compare/merge with the neighbor on the left, and whenever a merge happens the result re-checks the new left neighbor until everything is coprime.