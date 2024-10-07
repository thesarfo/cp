Given two non-negative integers, `low` and `high`, you need to count the number of odd numbers between `low` and `high` (inclusive).

[Leetcode 1528](https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/)

### Key Observations:
1. Odd numbers are numbers that are not divisible by 2, meaning `n % 2 == 1`.
2. We need to account for all odd numbers between `low` and `high`, inclusive. This includes both boundaries if they are odd.
3. We can determine the number of odd numbers within any range by noting the relationship between the size of the range and the frequency of odd numbers (every second number is odd).

### Approach Intuition:
- **Range Calculation**: The number of integers between `low` and `high` is `high - low + 1`.
- **Odd Number Pattern**: Odd numbers occur every two numbers. Therefore, approximately half of the numbers in any given range are odd.
  
#### Special Cases:
1. **Both Boundaries are Odd**: If both `low` and `high` are odd, the count of odd numbers increases by one because both boundaries are included as odd numbers.
2. **One Boundary is Odd**: If only one of the boundaries is odd, then the count remains the same as the basic pattern.
3. **Both Boundaries are Even**: The number of odd numbers in the range remains exactly half of the total number of numbers in the range.

### Solution Breakdown:
1. **Calculate the number of elements** between `low` and `high`: `result = high - low + 1`.
2. **Check if both boundaries are odd**: If both `low` and `high` are odd or at least one of them is odd, the odd count increases.
3. **Return the count of odd numbers** based on the division of the range size by 2 and handling edge cases based on whether the boundaries are odd or even.

### Code Explanation:

```java
class Solution {
    public int countOdds(int low, int high) {
        // Calculate the difference between high and low
        int result = high - low;

        // If the result (range) is even and high is odd, we can count (result/2) + 1 odd numbers
        if(result % 2 == 0 && high % 2 == 1){
            return result / 2 + 1;
        }  
        // If the result is odd, we also have (result / 2) + 1 odd numbers
        else if(result % 2 == 1){
            return result / 2 + 1;
        } 
        // In all other cases, return result / 2
        else{
            return result / 2;
        }
    }
}
```

### Intuition:
- **Range size**: The total number of numbers in the range is `high - low`.
- **Odd numbers**: Since every second number is odd, we roughly expect `result / 2` odd numbers.
- **Adjustment for boundaries**: When one or both of `low` or `high` is odd, we add 1 to the final count.

### Examples:
1. **Input: `low = 3`, `high = 7`**
   - Range: [3, 4, 5, 6, 7]
   - Odd numbers: [3, 5, 7]
   - Output: 3
   
2. **Input: `low = 8`, `high = 10`**
   - Range: [8, 9, 10]
   - Odd number: [9]
   - Output: 1

This solution provides a time complexity of O(1) since it's based on simple arithmetic calculations.