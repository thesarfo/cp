You are given two sorted arrays `nums1` and `nums2` of sizes `n` and `m` respectively. Your task is to find the `k`th smallest element when the two arrays are merged into a single sorted array.

#### Input
- `nums1`: An array of integers sorted in non-decreasing order.
- `nums2`: Another array of integers sorted in non-decreasing order.
- `k`: An integer representing the `k`-th element to find (1-indexed).

#### Output
- Return the `k`-th smallest element.

[Problem link](https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1?utm_source=youtube)

#### Example 1:
**Input**:  
```  
nums1 = [1, 3, 5], nums2 = [2, 4, 6], k = 4  
```
**Output**:  
```  
4  
```

#### Example 2:
**Input**:  
```  
nums1 = [10, 20], nums2 = [5, 15, 25], k = 3  
```
**Output**:  
```  
15  
```


### Approach 1: Brute Force (Merge and Sort)

#### Idea:
The simplest approach is to merge both arrays into a single sorted array and then directly pick the `k`/-th smallest element.

#### Steps:
1. Create a new array that contains all elements from `nums1` and `nums2`.
2. Sort this array in non-decreasing order.
3. Return the element at index (`k - 1`) (1-indexed).

#### Implementation:

```java
import java.util.*;

class Solution {
    public int findKthElement(int[] nums1, int[] nums2, int k) {
        // Merge arrays
        int[] merged = new int[nums1.length + nums2.length];
        int index = 0;
        
        for (int num : nums1) merged[index++] = num;
        for (int num : nums2) merged[index++] = num;
        
        // Sort the merged array
        Arrays.sort(merged);
        
        // Return the k-th element (1-indexed, so adjust by -1)
        return merged[k - 1];
    }
}
```

#### Complexity:
- **Time Complexity**: \(O((n + m) \log(n + m))\)  
  Sorting the merged array takes \(O((n + m) \log(n + m))\).
- **Space Complexity**: \(O(n + m)\)  
  A new array is created to store all elements.

#### Limitations:
This approach is simple but inefficient for large arrays due to the sorting step.


### Approach 2: Optimized Two-Pointer Technique

#### Idea:
Instead of merging both arrays into a new array, we can use two pointers to simulate merging. This eliminates the need for additional space and sorting.

#### Steps:
1. Use two pointers, `i` and `j`, starting at the beginning of `nums1` and `nums2`.
2. Use a counter to keep track of how many elements have been "merged."
3. Compare elements from both arrays and move the pointer of the smaller element forward.
4. When the counter reaches \(k\), return the current element.

#### Implementation:

```java
class Solution {
    public int findKthElement(int[] nums1, int[] nums2, int k) {
        int i = 0, j = 0, count = 0;

        while (i < nums1.length && j < nums2.length) {
            int smallerElement;
            if (nums1[i] <= nums2[j]) {
                smallerElement = nums1[i];
                i++;
            } else {
                smallerElement = nums2[j];
                j++;
            }

            count++;
            if (count == k) {
                return smallerElement;
            }
        }

        // If one array is exhausted
        while (i < nums1.length) {
            count++;
            if (count == k) {
                return nums1[i];
            }
            i++;
        }

        while (j < nums2.length) {
            count++;
            if (count == k) {
                return nums2[j];
            }
            j++;
        }

        return -1; // Should never reach here if k is valid
    }
}
```

#### Complexity:
- **Time Complexity**: \(O(k)\)  
  Only up to \(k\) elements are processed, making it efficient for small \(k\).
- **Space Complexity**: \(O(1)\)  
  No extra space is used apart from variables.

#### Advantages:
This approach avoids unnecessary sorting and works efficiently for small \(k\).


### Approach 3: Binary Search (Divide and Conquer)

#### Idea:
Leverage the sorted nature of the arrays to perform binary search on \(k\). By partitioning the arrays, we can eliminate half of the elements in each step.

#### Steps:
1. Treat the problem as finding the \(k\)-th element between two arrays.
2. Compare the midpoints of the arrays' current partitions.
   - If the sum of elements in the left partitions is less than \(k\), eliminate the smaller half.
   - Otherwise, eliminate the larger half.
3. Repeat until \(k\) elements remain.

#### Implementation:

```java
class Solution {
    public int findKthElement(int[] nums1, int[] nums2, int k) {
        return findKth(nums1, 0, nums2, 0, k);
    }

    private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1]; // nums1 exhausted
        if (j >= nums2.length) return nums1[i + k - 1]; // nums2 exhausted
        if (k == 1) return Math.min(nums1[i], nums2[j]); // Base case

        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;

        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
```

#### Complexity:
- **Time Complexity**: \(O(\log(k))\)  
  Each step reduces the search space by half.
- **Space Complexity**: \(O(\log(k))\)  
  Due to the recursive stack.