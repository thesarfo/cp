You've been given sorted integer array with distinct values. Now the array is rotated between 1 to n times which is unknown. Your goal is to find the minimum element in the array.

[Leetcode 153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array)

**For example**

Example 1:
Input Format:
`arr = [4,5,6,7,0,1,2,3]`
Result:
 `0`
Explanation:
 Here, the element `0` is the minimum element in the array.

Example 2:
Input Format:
`arr = [3,4,5,1,2]`
Result:
 `1`
Explanation:
 Here, the element `1` is the minimum element in the array.


1. **Brute Force Approach - Linear Search**: Obviously, we can use a linear search approach where we have an `ans` variable initialized to a very large integer, and then we loop through the input array to find which element is lesser than `ans` and so on - if we find a number lesser than `ans` we assign nums to it. This solution is not really that efficient.

2. **Optimal Approach - Binary Search**: The key observation here is that, if the array is sorted and rotated, we already know that for every index, one of the 2 halves of the array will always be sorted.

Based on this, we can adopt a straightforward process to eliminate one-half of the rotated sorted array.

* First, we identify the sorted half of the array
* Once found, we determine if the target is located withhin this sorted half.
    - If not, we eliminate that half from further consideration
    - If the target is in the sorted half, we eliminate the other half

We can identify the sorted half by comparing `arr[mid]` with `arr[low]` and `arr[high]`


- If `arr[low] <= arr[mid]`: In this case, the left half is sorted
- If `arr[mid] <= arr[high]`: The right half is sorted

 
**How then do we find the minimum element?** - There are 2 possibilities to consider. THe sorted half of the array may or may not contain the minimum value. But, we can leverage the property of the sorted half, specifically the leftmost element of the sorted half will always be the minimum element within that particular half.

So, during each iteration, we will select the leftmost element from the sorted half and discard that half from further consideration. Among all the selected elements, the minimum value will serve as our answer.

We can declare a variable called `ans` and initialize it to a large number. Then, at each step, after selecting the leftmost element from the sorted half, we will compare it withi `ans` and update `ans` with the smaller value. i.e `min(ans, leftmost_element)`.

**Note**: If, at any index, both the left and right halves of the array are sorted, we have the flexibility to select the minimum value from either half and eliminate that particular half (in this case, the left half is chosen first). The algorithm already takes care of this case, so there is no need for explicit handling.

Below is a code implementation

```java
public static int findMin(int[] arr){
    int low = 0, high = arr.length - 1;
    int ans = Integer.MAX_VALUE;

    while(low <= high){
        // left half is sorted
        if(arr[low] <= arr[mid]){
            ans = Math.min(ans, arr[low]); // keep the minimum in this half
            low = mid + 1; // eliminate the half
        } else{
            ans = Math.min(ans, arr[mid]); // keep the minimum in this half
            high = mid - 1; eliminate the half
        }
    }
    return ans;
}
```


Technically, we can still optimize this solution - if both the left and right halves of an index are sorted, it means that the entire space between the low and high indices are also sorted. In this case, there's no need to conduct a binary search within that part to find the minimum value. Instead, we can simply selece the leftmost element as the minimum.

The condition to check that will be `arr[low] <= arr[mid] && arr[mid] <= arr[high]`. We can even shorten it into `arr[low] <= arr[high]`

If `arr[low] <= arr[high]`: In this case, the array from index low to high is completely sorted. Therefore, we can simply select the minimum element, `arr[low]`, and update the `ans` variable with the minimum value i.e. `min(ans, arr[low])`. Once this is done, there is no need to continue with the binary search algorithm.

So, its basically the same process as above, just that we need to first check if the entire array is sorted then we forgo the binary search process.

Below is a code implementation

```java
public static int findMin(int []arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            //search space is already sorted
            //then arr[low] will always be the minimum in that search space:
            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                ans = Math.min(ans, arr[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, arr[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
}
```

The TC of this algo is O(logN). SC is O(1)