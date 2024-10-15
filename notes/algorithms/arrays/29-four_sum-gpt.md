### Problem Restatement
You are given an array of integers and your goal is to find **unique quadruples** (four different numbers at different indexes) that sum up to a given target. The array can contain both positive and negative integers, and you want to avoid duplicate quadruples in the result.

For example, given the array `[1, 0, -1, 0, -2, 2]` and `target = 0`, a valid output would be all unique sets of four numbers that sum to `0`.

### Approach 1: **Brute Force** - O(n^4)
#### Idea:
The brute force solution would involve checking every possible combination of four numbers in the array. This means trying every unique combination of four indices `[i, j, k, l]` and checking if their sum matches the target.

##### Code:
```java
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(temp);
                            set.add(temp);  // To avoid duplicates
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
```

- **Intuition**: Try every possible combination of four elements and check if their sum matches the target.
- **Downside**: This takes **O(n^4)** time, which is inefficient for larger arrays. We need a better solution.

### Approach 2: **Using Hashing** - O(n^3)
#### Idea:
We can reduce one of the four loops by using a **hashset** to track previously seen numbers, similar to how you might solve the 3Sum problem. The idea is to treat the fourth number as `nums[l] = target - (nums[i] + nums[j] + nums[k])`. By doing this, we can find the fourth number by looking it up in a set, avoiding the need for a fourth loop.

##### Code:
```java
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = target - sum;

                    if (hashset.contains(fourth)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        Collections.sort(temp);  // To avoid duplicates
                        set.add(temp);
                    }
                    hashset.add((long) nums[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
```

- **Intuition**: By reducing the fourth loop to a lookup in a hashset, we optimize the time complexity. Instead of checking every combination, we check three numbers and then find the fourth using the hashset.
- **Downside**: We are still using extra space for the hashset, and it might still be slow due to the nested loops.

### Approach 3: **Optimal Solution Using Two Pointers** - O(n^3)
#### Idea:
To further optimize, we use the **two-pointer technique**. First, we sort the array, which allows us to use two pointers (`k` and `l`). For every pair of `i` and `j`, we treat `k` and `l` as the leftmost and rightmost pointers of the remaining array. The goal is to move `k` and `l` inward based on the sum of the four numbers.

1. **Fix `i` and `j`**: These are the first two numbers.
2. **Use Two Pointers `k` and `l`**: These two pointers scan the remaining part of the array for potential third and fourth numbers.

##### Code:
```java
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array first

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // Skip duplicate numbers for `i`
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                // Skip duplicate numbers for `j`
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                // Use two pointers `k` and `l`
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        // Skip duplicates for `k`
                        while (k < l && nums[k] == nums[k - 1]) k++;

                        // Skip duplicates for `l`
                        while (k < l && nums[l] == nums[l + 1]) l--;

                    } else if (sum < target) {
                        k++;  // Move `k` pointer to the right if sum is less than target
                    } else {
                        l--;  // Move `l` pointer to the left if sum is greater than target
                    }
                }
            }
        }
        return ans;
    }
}
```

- **Intuition**: 
   - Sorting the array helps us use the two-pointer technique.
   - We fix two numbers and use two pointers to find the remaining two numbers.
   - The key idea is moving the pointers inward to adjust the sum dynamically.
- **Advantages**: 
   - No extra hashset is needed, and we efficiently avoid duplicates.
   - The time complexity is **O(n^3)**, which is much better than the brute force approach.

### Summary of Steps:
1. **Sort the Array**: Sorting helps us use the two-pointer approach.
2. **Fix Two Numbers (`i` and `j`)**: These are the first two numbers of the quadruple.
3. **Use Two Pointers (`k` and `l`)**: These pointers help find the remaining two numbers.
4. **Adjust Pointers Based on Sum**: If the sum is too large, move the right pointer left. If too small, move the left pointer right.
5. **Skip Duplicates**: Ensure you skip any duplicate numbers to avoid repeating the same quadruple.

This approach ensures a balance between time complexity and space usage, and the intuition behind each step is rooted in simplifying the brute force approach by using smarter techniques like sorting and two-pointers.