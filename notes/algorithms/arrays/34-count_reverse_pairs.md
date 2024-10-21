You are given an array of integers, and your task is to find out the number of pairs where the left element is greater than 2 times the right element.

For instance, given the array `[40, 25, 19, 12, 9, 6, 2]`, the pairs that satisfy the condition are `[6, 2]`, `[9, 2]`, `[12, 2]`, `[19, 2]`, `[25, 2]`, `[40, 2]` and so on. Therefore, the total number of pairs are `15`.

[Leetcode 493](https://leetcode.com/problems/reverse-pairs/description/)
[Code 360](https://www.naukri.com/code360/problems/team-contest_6840309)

1. **Brute Force Solution**: We can generate all the pairs, since we need an `i` and `j`, we can set an `i` pointer at the first element and move the `j` pointer across to the end of the array. We keep on doing this while checking our condition to generate the pairs. 

Below is a code implementation

```java
int count = 0;

for(int i = 0; i < n-1; i++){
    for(int j = i + 1; j < n; j++){
        if(arr[i] > 2 * arr[j]){
            count++;
        }
    }
}
return count
```
The TC if O(n2) while the TC is O(1)

We should find a way to optimize the TC of the above, to either an `nlogn` or an `O(n)`. We can use merge sort to help solve this problem

2. **Optimal Solution**: To optimize the solution, we can leverage the divide-and-conquer strategy of **Merge Sort**. Merge Sort automatically divides the array into smaller subarrays and sorts them during the merging process. Here's how we can modify it to check for pairs that satisfy the condition `left > 2 * right` before merging.

**Steps:**
1. **Divide** the array into smaller subarrays as in merge sort.
2. **Check the condition**: Before merging the subarrays back together, for each element in the left subarray, check if it forms a valid pair with any element in the right subarray `left > 2 * right`.
3. **Merge** the subarrays back into sorted order while keeping track of the valid pairs.

Thus, we simultaneously count valid pairs and sort the array. This allows us to efficiently check all pairs as we merge.

In essence, while dividing the array, we check for pairs between the left and right subarrays before they are merged. This significantly reduces the number of comparisons and brings the time complexity down.

Below is a code implementation

```java
import java.util.ArrayList;

public class Solution {

    // Function to merge two sorted subarrays
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // Temporary array
        int left = low;      // Starting index of left half of arr
        int right = mid + 1; // Starting index of right half of arr

        // Storing elements in the temporary array in sorted order
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // Add remaining elements from the left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Add remaining elements from the right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Transfer all elements from the temp array back to the original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // Function to count the number of valid pairs
    private static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    // Merge sort function with counting pairs step
    private static int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;  // Base case for recursion
        int mid = (low + high) / 2;

        // Recursively sort left and right halves and accumulate counts
        int count = mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        // Count the pairs and then merge the sorted subarrays
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);

        return count;
    }

    // Public function to initiate the sorting and counting process
    public static int team(int[] skill, int n) {
        return mergeSort(skill, 0, n - 1);
    }
}
```

The TC of the above solution is O(2nlogn) while the SC is O(n)