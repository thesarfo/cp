You are given two sorted integer arrays, and your task is to merge these arrays without using any extra space. For instance, given a first array arr1 `[1, 3, 5, 7]` and second arr2 `[0, 2, 6, 8, 9]`, in the given arrays itself, we have to make sure that we reshuffle them in a way that they are in sorted order. For instance, arr1 will be `[0, 1, 2, 3]` and arr2 will be `[5, 6, 7, 8, 9]`.

[LeetCode 88](https://leetcode.com/problems/merge-sorted-array/description/)

1. **Brute Force Solution**: Since both the arrays are sorted, we can create a third array, and keep two pointers at the first positions in both arrays, and based on which elements are smaller on the pointers, we add them to the third array. We keep doing that until we reach the end of one array, then we can just add the rest of the elements in the other array to our answer array.

An then, we pick elements in the third array from index 1 to arr1.length, and replace them in arr1. Then we pick the rest of the elements and place them in the second array.

The problem with this problem is that we end up creating a third array which consumes extra space.

Below is a sample code solution

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Create a dynamic list to store the merged result
        List<Integer> union = new ArrayList<>();

        // Initialize two pointers to traverse nums1 and nums2
        int i = 0, j = 0;

        // Merge elements from both arrays until one of them is fully traversed
        while (i < m && j < n) {
            // If the current element in nums1 is smaller or equal, add it to the union
            if (nums1[i] <= nums2[j]) {
                union.add(nums1[i]);
                i++;  // Move the pointer in nums1
            } else {
                // If the current element in nums2 is smaller, add it to the union
                union.add(nums2[j]);
                j++;  // Move the pointer in nums2
            }
        }

        // If there are remaining elements in nums1, add them to the union
        while (i < m) {
            union.add(nums1[i]);
            i++;  // Move the pointer in nums1
        }

        // If there are remaining elements in nums2, add them to the union
        while (j < n) {
            union.add(nums2[j]);
            j++;  // Move the pointer in nums2
        }

        // Copy the merged result from the union list back to nums1
        // nums1 is modified in-place to store the merged result
        for (int k = 0; k < union.size(); k++) {
            nums1[k] = union.get(k);  // Overwrite nums1 with the elements from union
        }
    }
```

The TC is 0(m+n) + 0(m+n) and the SC is 0(m+n)

We need to get rid of the extra space

2. **Optimal Solution**: Keep in mind that both arrays are sorted. We can stand at the last/largest element in arr1 and compare it with the first/smallest element in arr2, we compare them to see which one is smaller and then we swap their positions if eligible and keep going. But if the element at arr1 is smaller than the element at arr2, we dont swap them.

After doing this, all elements will be in their right arrays, then we can then resort arr1 and arr2.

Below is a code implementation

```java
public static void mergeTwoSortedArraysWithoutExtraSpace(long[] a, long[] b) {
    int m = a.length;
    int n = b.length;

    int left = m - 1;  // Start from the last element of array a
    int right = 0;     // Start from the first element of array b

    // Swap elements until all elements in 'a' are less than or equal to 'b'
    while (left >= 0 && right < n) {
        if (a[left] > b[right]) {
            // Swap the larger element from 'a' with the smaller one from 'b'
            long temp = a[left];
            a[left] = b[right];
            b[right] = temp;

            left--;  // Move left pointer in 'a' backward
            right++; // Move right pointer in 'b' forward
        } else {
            break; // If elements are in correct order, stop the loop
        }
    }
}
```

The TC of the above solution is 0(min(n, m)) + 0(n log n) + 0( m log m) while the SC is 0(1)

### Another Optimal Solution - Gap Method

This method uses another sorting technique called **Shell Sort**. First, we take the size of arr1, then the size of arr2 - sum them up and divide them by 2. If the result is a decimal we take the ceiling value of that. That value is going to be our **gap**. We will then keep a first pointer at first element in arr1, and our second pointer will be at **gap** distances away - note that the second pointer can move to arr2. Then we compare the values and swap accordingly.

The moment one of the pointers move out of bounds, we restart the process. We restart it by dividing our **gap** by 2, and then restart the first pointer at arr1's first element and second pointer at gap distances away. We then keep comparing and swapping, restarting as usual until the gap reaches 1.

Below is a code implementation

```java
import java.util.Arrays;

    public static void mergeTwoSortedArraysWithoutExtraSpace(long[] a, long[] b) {
        int n = a.length;
        int m = b.length;

        int len = n + m;
        int gap = (len / 2) + (len % 2);

        // Perform the gap-based merge
        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                // If left is in 'a' and right is in 'b'
                if (left < n && right >= n) {
                    swapIfGreater(a, b, left, right - n);
                }
                // If both left and right are in 'b'
                else if (left >= n) {
                    swapIfGreater(b, b, left - n, right - n);
                }
                // If both left and right are in 'a'
                else {
                    swapIfGreater(a, a, left, right);
                }
                left++;
                right++;
            }

            // If gap becomes 1, we're done
            if (gap == 1) break;

            // Reduce the gap
            gap = (gap / 2) + (gap % 2);
        }
    }

    // Swap elements if the element at ind1 is greater than the element at ind2
    private static void swapIfGreater(long[] a, long[] b, int ind1, int ind2) {
        if (a[ind1] > b[ind2]) {
            long temp = a[ind1];
            a[ind1] = b[ind2];
            b[ind2] = temp;
        }
    }
```
