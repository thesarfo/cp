You are given an integer array, and your task is to find all the triplets that sum up to zero. A triplet refers to an array of three integers. 

#### Constraints:
- You are not allowed to take the same element more than once (i.e., `i != j != k`).
- You cannot include duplicate triplets; all the triplets you generate should be unique.

[LeetCode 15](https://leetcode.com/problems/3sum)

#### Example:
**Input Array:**  
```plaintext
[-1, 0, 1, 2, -1, -4]
```

**Expected Output:**  
```plaintext
[[-1, -1, 2], [-1, 0, 1]]
```

### Explanation:
In the given array, the unique triplets that sum to zero are:
- `[-1, -1, 2]`
- `[-1, 0, 1]`

**Note:** The triplet `[0, 0, 0]` is not possible in this case since we only have one instance of `0` in the input array.

1. **Brute Force**: We can try to find all the possible triplet combinations that sum up to our target(0). We do this using the **three pointer** approach, where in the beginning, the first two pointers are the first two elements in our array - the third pointer will range from the second pointer to the end of the array. When the third pointer reaches the third of the array, we move the second pointer to the right, and check for all possible triplets using the third pointer till the end of the array. We keep repeating this process till we find the triplets, or there is nothing else to do

As far as maintaining unique triplets, we can sort each triplet, and put it into a set(since we are dealing with a unique value here). Now before we add a triplet to the set, we sort the triplet, and check if its sorted version is in the set, if not we add it.

Below is a pseudocode

```java
// create a set of a list of integers
for(i = 0; i < n; i++){
    for(j = 1 + 1; j < n; j++){
        for(k = j + 1; k < n; j++){
            if[arr[i] + arr[j] + arr[k] == 0]{
                // store i, j, k in a temporary list
                // sort the list
                // add the list to the set
            }
        }
    }
}
// add all elements in the set to a new list and return that list
```

Below is a sample implementation in java

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> unique = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);
                        unique.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(unique);
    }
}
```

The TC of the above approach is nearly 0(n3). There has to be a better way. We can probably optimize it to 0(n2), maybe by getting rid of the third loop.

Can we say the third element we're looking for is the negative version of the first two elements we have? We are looking for a triplet where `arr[i] + arr[j] + arr[k] = 0`, but can we say that `arr[k] = -(arr[i] + arr[j])`? yes we can, that is simple mathematics.

For instance, if `i = -1` and `j = -1` and we're looking for `k`, we can deduce that `k = -(-1 + -1)` which gives us `2`. Now all we have to do is to check if our array contains a `2`, then we have found our triplet. In order to look for the `2` in our array, we will use the technique called **Hashing**. However, keep in mind that the `2` we are looking for should be unique - i.e it shouldn't have already been picked for `arr[i]` or `arr[j]`

2. **Better Approach - Hashing**:  We create a set. And we start with our `i` and `j` pointers. Now on each position of `i` and `j`, we apply the formula `-(arr[i] + arr[j])`, and we check if the result of this formula is in our set, if it isn't, we move our `j` pointer to the right. But before `j` actually moves, we need to add it to our set. So that we can use it later. 

On another iteration, we apply the formula, check if the third element is in the set, if it is, we have found our triplet so we sort the triplet and store it, preferably in a set(different set than the one storing)

Below is a sample implementation in Java

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0; i < n; i++){
            Set<Integer> store = new HashSet<>();
            for(int j = i + 1; j < n; j++){
                int third = -(nums[i] + nums[j]);
                if(store.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    result.add(temp);
                }
                store.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
}
```

The TC of the above solution is near about 0(n2). The SC is 0(n) + 0(n log n) * 2.

Can we optimize the SC? We could probably get rid of the extra sets.

We can sort the array, and come up with an algorithm that come's up with the triplets without using a set.

3. **Optimal Solution - Two Pointers**: Now we have sorted the array, we can place our `i` and `j` pointers to the first 2 elements in the array(`j` is put at `i+1`), and then we place our `k` pointer to the last element int the array. We will add up all the three elements, and check if the result is greater or less than `0`.

Note that our `i` pointer is constant. It will **not** move. Therefore we have to choose to move either the `j` or `k` pointer depending on the result of our addition. If the result is less than `0`, that means we need to increase the result to get `0`, now since we know that our array is sorted, we can move the `j` pointer to the right.(right means increasing), if the result is lesser than `0`, we move our `k` pointer to the left(left means decreasing).

If at any point in time, `i + j + k = 0`, we have found a triplet. We can then store the triplet somewhere(no need to sort it because the array is already in the sorted order).

But there's a catch, since the triplets should be absolutely unique, we cannot use the same elements that `j` and `k` pointed to. So we can move both of these pointers inward, to an element that they were not previously pointing to - stop moving these pointers when they both point to the same element, or they cross each other.

Now, we move our `i` pointer inward - to an element that it wasn't previously pointing to, and then our `j` pointer is set next to `i`. (`j = i + 1`), and our `k` pointer points to the last element as usual. We add them and check if they're greater than or equal to `0`, and based on the result, we either move the `j` pointer or `k` pointer inward, to an element that they both have not pointed to before

Below is a sample implementation in java

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = n - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                } else if (sum > 0){
                    k--;
                }
                else{
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    answer.add(temp);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k-1]) k--;
                }
            }
        }
        return answer;
    }
}
```

The TC of the above is 0(n log n) + 0(n * n), while the SC is 0(no of unique triplets).