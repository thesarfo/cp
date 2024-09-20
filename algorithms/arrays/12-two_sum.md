There are two varieties of this problem

[Leetcode 1](https://leetcode.com/problems/two-sum/)

First variety: You are given an array, and your goal is to see if there exists some two numbers that add up to a target number. For instance, given an array `[2, 6, 5, 8, 11]` and the target `14`. You will return `true` if these two numbers that add up to `14` exist - `[8, 6]`. `false` if otherwise.


Second variety: You are given an array, and you are sure that there are two numbers that add up to the target. Your goal is to return the indexes of these two numbers. For instance, for an array `[2, 6, 5, 8, 11]` and a target `[14]` - you will return `[1, 3]`, since `8` and `6` add up to `14` and those are their indexes.

1. **Brute Force Solution**: You can pick a single element, and compare with the rest of the elements in the array, and check if they sum up to the target. 

```pseudocode
for(i = 0; i < n; i++){
    for(j = 0; j < n; j++){
        if(i == j) continue;
        if(arr[i] + arr[j] == target){
            either return true / false or return i and j(indexes)
        }
    }
}
```

The above problem has quadratic complexity

2. **Another Brute Solution**: Now, if you look at the above solution, we compared each number with all the numbers in the array - even though we knew that some of these comparisons wouldn't add up to the target. So, if we start from the first element, and we compare `2` and `6`, when we get to `6`, is there a point in comparing `6` and `2`? No. because we know from the very first comparison that it doesn't add up to the target. So now, on each comparison, we only compare the current element to elements on the right of it - elements it hasn't already been compared to.

```pseudocode
for(i = 0; i < n; i++){
    for(j = i + 1; j < n; j++){
        if(arr[i] + arr[j] == target){
            either return true / false or return i and j(indexes)
        }
    }
}
```

3. **Better Solution**: The better approach employs a HashMap (or dictionary) to significantly reduce the time complexity to O(n). The HashMap stores elements as keys and their indices as values. As you traverse the array, for each element, you compute the difference between the target and the current element. You then check if this difference already exists in the HashMap. If it does, you’ve found your solution: the current element and the stored element sum to the target. If not, you add the current element to the HashMap and continue iterating.

Below is some pseudocode
```pseudocode
for each element in array:
    subtract the element from target
    if the result exists in the HashMap:
        return the current index and the index from the HashMap
    else:
        add the current element and its index to the HashMap
```

below is some c++ implementation

```cpp
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> mpp; // This stores the element and its index
        for (int i = 0; i < nums.size(); i++) {
            int a = nums[i];
            int more = target - a; // Calculate what is needed to reach the target
            if (mpp.find(more) != mpp.end()) { // If the complement is found
                return {mpp[more], i}; // Return the pair of indices
            }
            mpp[a] = i; // Otherwise, store the element and its index
        }
        return {0, 0}; // Return a default value if no solution exists (for safety)
    }
};
```
Time Complexity: O(n)