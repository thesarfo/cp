You've been given an integer array `arr` of size `n`, sorted in ascending order(with distinct values). Now, the array is rotated between 1 to `n` times which is unknown. Your goal is to find how many times the array has been rotated.

For example 

Example 1:
Input Format:
`arr = [4,5,6,7,0,1,2,3]`
Result:
`4` <br>
Explanation:
The original array should be `[0,1,2,3,4,5,6,7]`. So, we can notice that the array has been rotated `4` times.

**Intuition**

How does the rotation occur in a sorted array? Let's consider a sorted array: `{1, 2, 3, 4, 5}`. If we rotate this array `2` times, it will become `{4, 5, 1, 2, 3}`. In essence, we moved the element at the last index to the front, while shifting the remaining elements to the right. We performed this process twice.

**Observation**

- We can easily observe that the number of rotations in an array is equal to the index(0-based index) of its minimum element.
- So, in order to solve this problem, we need to find the index of the minimum element.


**Solution - Using Binary Search**

In this [example](45-minimum_in_rotated_sorted_array.md), we talked about how to find the minimum element in a rotated and sorted array using Binary Search. In this problem, we will use the same algo to determine the index of the minimum element. In the above example, we only stored the minimum element itself. But, in this new approach, we will additionally keep track of the index. This small adjustment will solve the problem

1. First, we will declare the variable `ans`, and initialize it with the largest possible value. Also, we will have two pointers, `low` and `high`, as usual. But in this case, we will also introduce an `index` variable and initialize it to `-1`

2. Place the 2 pointers to the first and last index respectively - and then inside a loop we will calculate for the value of `mid`

3. If `arr[low] <= arr[high]` In this case, the whole array is completely sorted. So, we can just select the minimum element i.e `arr[low]`. Now, if `arr[low] < ans` we will update `ans` with the value of `arr[low]` and `index` with the corresponding index `low`. Once this is done, there is no need for a binary search, so we will break from this step.

4. Identify the sorted half, and after picking the leftmost element, eliminate that half

    - If `arr[low] <= arr[mid]`: This means the let part is sorted. So we will pick the leftmost element i.e `arr[low]`. Now, if `arr[low] < ans` we will update `ans` with the value `arr[low]` and `index` with the corresponding index `low`. After that we just eliminate the left half(`low = mid + 1`).
      - Otherwise, we know that the right half is sorted. So we will pick the leftmost element i.e `arr[mid]`. Then if `arr[mid] < ans`, we will update `ans` with the value `arr[mid]` and `index` with the corresponding index mid. After that we just eliminate the right half(`high = mid - 1`)

5. Finally, we'll just return the `index` variable that stores the index of the minimum element.


Below is a code implementation

```java
public class Solution {
    public static int findKRotation(int []arr){
        // Write your code here.
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE, index = -1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[low] <= arr[high]){ // entire array/search-space is already sorted
                if(arr[low] < ans){
                    index = low;
                    ans = arr[low];
                }
                break;
            }

            if(arr[low] <= arr[mid]){ // left part is sorted
               // keep the minimum
                if(arr[low] < ans){
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            } else{ // right part is sorted
               // keep the minimum
                if(arr[mid] < ans){
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }


        
        return index;
    }
}
```