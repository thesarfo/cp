#### Problem Description

You will be given a sorted array of integers, for example `[1, 1, 2, 2, 2, 3, 3]`. The problem requires you to remove duplicates from this sorted array, leaving only the unique elements. In the above example, there are only `3` unique elements in the array: `[1, 2, 3]`. Therefore, after removing duplicates, your answer should reflect just those unique elements. It is not necessary to modify the remaining elements in the array after the unique ones; your task is to return the number of unique elements. In this case, it should return `3`.

1. **Brute Force Approach**

Whenever we talk about "unique elements", a set comes to mind, because sets do not allow duplicate entries. Therefore, we can create a new `Set` (e.g., a `HashSet`), and add all the elements of the array into the set. Since the set will automatically remove duplicates, it will contain only the unique values of the original array. After that, we place the elements of the set back into the array starting from the first index.

Below is a simple implementation in Java
```java
import java.util.HashSet;

public class Solution {
    public static int removeDuplicates(int[] arr, int n) {
        HashSet<Integer> result = new HashSet<>();

        // Add all elements from array to set, automatically removing duplicates
        for (int i = 0; i < n; i++) {
            result.add(arr[i]);
        }

        // Overwrite the original array with unique elements from the set
        int idx = 0;
        for (int item: result) {
            arr[idx] = item;
            idx++;
        }

        // Return the number of unique elements
        return result.size();
    }
}
```

2. **Optimized Solution**: 
The brute force solution works, but it can be optimized both in terms of time and space. Since the array is sorted, we can take advantage of this property and avoid the extra space required by the Set.

We can use the 2 pointer approach to optimize this solution. The array is sorted, and we know that the first element will always stay at the same place regardless. Therefore, we can check from the the other elements in the array, starting from the second index to see if they are equal to the first element or not. If they are not equal, you place them at the second place. Then you check the rest of the elements to see the one which is not equal to the second element

**Key Idea:**
We can use two pointers:

* **Pointer 1 (i)**: Keeps track of the position where we place the next unique element.
* **Pointer 2 (j)**: Iterates through the array to find unique elements.

Initially, both pointers start at the beginning of the array. The first element is always unique, so we move `j` forward to find the next unique element. Whenever we find a new unique element (i.e., `nums[j] != nums[i]`), we increment `i` and copy the value of `nums[j]` to `nums[i]`.

At the end, the unique elements will be stored at the beginning of the array, and the number of unique elements will be `i + 1` (since `i` is the index of the last unique element).

A pseudocode will look like this
```pseudocode
i = 0;
for(int j = 1; j < n; j++){
    if(arr[j] != arr[i]){
        arr[i + 1] = arr[j];
        i++;
    }
}
return i + 1;
```


Below is how a simple C++ implementation would look like
```cpp
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0;

        for(int j = 1; j < nums.size(); j++){
            if(nums[j] != nums[i]){
                nums[i + 1]  = nums[j];
                i++;
            }
        }
        return i + 1;
    }
};
```


**Example Walkthrough:**
For an array nums = `[1, 1, 2, 2, 2, 3, 3]`:

1. Start with two pointers `i = 0` and `j = 1`.
2. Compare `nums[j]` with `nums[i]`. If they are different, increment i and copy `nums[j]` to `nums[i]`.
    * After processing `j = 1`: No change, since `nums[1] == nums[0]`.
    * After processing `j = 2`: `nums[2] != nums[0]`, so increment `i` and copy `nums[2]` to `nums[1]`.
    * Continue this process for all elements.
3. The array will be modified to `[1, 2, 3, _, _, _, _]`, and the function will return `3` (the number of unique elements).