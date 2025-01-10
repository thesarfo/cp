
You are given two events represented as arrays of time intervals:
- `event1 = [start1, end1]`
- `event2 = [start2, end2]`

Each time is given in the format `"HH:MM"`, representing a 24-hour clock.

Your task is to determine if these two events **conflict**. Two events conflict if they overlap at any point in time (including touching at boundaries).

[LeetCode Problem](https://leetcode.com/problems/determine-if-two-events-have-conflict/)

#### **Examples**

1. **Example 1**
   - Input:  
     `event1 = ["01:15","02:00"]`  
     `event2 = ["02:00","03:00"]`  
   - Output: `true`  
   - Explanation: The two events intersect at the time `02:00`.

2. **Example 2**
   - Input:  
     `event1 = ["01:00","02:00"]`  
     `event2 = ["01:20","03:00"]`  
   - Output: `true`  
   - Explanation: The two events overlap between `01:20` and `02:00`.

3. **Example 3**
   - Input:  
     `event1 = ["01:00","01:30"]`  
     `event2 = ["02:00","02:30"]`  
   - Output: `false`  
   - Explanation: The two events do not overlap.


#### **Steps to Solve**

1. **Convert Time Strings to Minutes**
   - Parse the `HH:MM` format to calculate the total minutes since midnight.
     \[
     \text{totalMinutes} = (\text{hours} \times 60) + \text{minutes}
     \]
   - Example:
     - `"01:15"` → \( (1 \times 60) + 15 = 75 \)
     - `"02:00"` → \( (2 \times 60) + 0 = 120 \)

2. **Check for Overlap**
   - Two events overlap if:
     \[
     \text{start1} \leq \text{end2} \, \text{and} \, \text{start2} \leq \text{end1}
     \]
   - This ensures:
     - `event1` starts before `event2` ends.
     - `event2` starts before `event1` ends.


Below is a code implementation

```java
class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        // Convert event times to minutes
        int start1 = timeToMinutes(event1[0]);
        int end1 = timeToMinutes(event1[1]);
        int start2 = timeToMinutes(event2[0]);
        int end2 = timeToMinutes(event2[1]);

        // Check for overlap (inclusive boundary condition)
        return start1 <= end2 && start2 <= end1;
    }

    // Helper function to convert "HH:MM" to total minutes since midnight
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
```

The TC and SC of this solution are both O(1)