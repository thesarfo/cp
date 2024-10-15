You are given an array of integers and your task is to find 4 different indexes such that if you sum up the numbers at those indexes, you get the target. However, the numbers should be unique. i.e `[i != j != k != l]`

For instance, given the array `[1, 0, -1, 0, -2, 2]` and a `target = 0`


1. **Brute Force**: We can try out all the possible quads and whichever quad adds up to our target, we store them in a set - since those are our answers

Below is a simple implementation

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
                            set.add(temp);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}
```

The TC of this is about 0(n4), and the space complexity is 0(n of quads) * 2. There has to be a better solution

2. **Better Solution - Hashing**: We can get rid of the fourth loop in the brute force solution and use only three loops. What we can do is that, to find the `l` element, we can deduce it as `nums[l] = target - (nums[i] + nums[j] + nums[k])`, this is simple substitution in mathematics. So we can run 3 loops to generate all the possible triplets, and now we can look at the possible fourth value based on the above formula, and check if the fourth value exists in the array - then we have found our quad.

So just like we did with the 3sum problem, we can run a loop for `i`, `j` and `k`, now as our `k` pointer moves, we will store everything between `j` and `k` into a hashset. This means that we will put our `i`, `j`, and `k` pointers to the first 3 elements of our array respectively, and on each iteration, we try to find the `l` based on the above formula, once we find `l`, we check if it exists in the hashset - if it doesn't, the element at `k` is added to the hashset and the k pointer moves to the right.

Below is a code implementation 

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
                        Collections.sort(temp);
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

The TC of this is 0(n3) * log(m) while the SC is 0(n) + 0(quads) * 2. 

Can we still find a better approach? Yes we can. We need to get rid of 2 things, first is the hashset that we were using to lookup in the array, and the set that we used to store the unique quads. 

3. **Optimal Solution - Two Pointers**: We can put our `i`, `j` and `k` pointers to the first 3 elements of the array - note that `i` and `j` are constant/fixed. Then we put our `l` pointer to the last element in the array. On each iteration, we add all elements at the 4 pointers and check if they sum up to our target, if they do, we store them, and then move our `k` and `l` pointers inward - however note that when you move these two pointers inward, you need to skip duplicates, i.e move the pointers to a value that they have never seen/pointed to before. 

Then you can check again if the sum of all four add up to the target, if the sum is greater than our target, we move our `l` pointer inward, if the sum is less than our target, we move our `k` pointer inward. We keep doing this until `k` and `l` cross each other(point to the same element).

After the above, we can move the `j` pointer inward, `k` pointer will be at `j+1` and `l` will be at the last. We keep doing that until `j` points to the last element in the array, then we can start moving `i`. But make sure that when moving `i` and `j` we skip duplicates by making sure that these pointers don't point to an element they have seen before.

Below is a sample code implementation

```java
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // Skip duplicate elements for the first pointer
            if (i != 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                // Skip duplicate elements for the second pointer
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];  // Calculate the sum

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        // Skip duplicates for the third pointer
                        while (k < l && nums[k] == nums[k - 1]) k++;

                        // Skip duplicates for the fourth pointer
                        while (k < l && nums[l] == nums[l + 1]) l--;

                    } else if (sum < target) {
                        k++;  // Move third pointer right if sum is less than target
                    } else {
                        l--;  // Move fourth pointer left if sum is greater than target
                    }
                }
            }
        }

        return ans;
    }
}
```