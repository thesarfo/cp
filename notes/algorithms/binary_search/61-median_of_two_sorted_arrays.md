You are given two sorted arrays `nums1` and `nums2` of sizes `n` and `m` respectively. Your task is to return the median of these two arrays.

The median value simply refers to the element that appears in the middle of an array.

- [Leetcode Problem](https://leetcode.com/problems/median-of-two-sorted-arrays/description/)
- [Another Problem Link](https://www.naukri.com/code360/problems/median-of-two-sorted-arrays_985294)

### 1. Brute Force Approach

1. **Merging Two Arrays**:
   - The two input arrays are merged into a single sorted list.
   - This ensures that all elements are in order, allowing us to find the median directly.

2. **Median Calculation**:
The median of an the combined list may be different based on the size of the list. 
   - **Odd-sized List**: The median is the middle element, since there are equal number of elements to the left and right of it. This is calculated as `size / 2` (integer division), where `size` is the total number of elements in the merged list.
   - **Even-sized List**: The median is the average of the two middle elements. These elements are located at indices `size / 2 - 1` and `size / 2`.

Below is a code implementation

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merged.add(nums1[i]);
                i++;
            } else {
                merged.add(nums2[j]);
                j++;
            }
        }
        while (i < nums1.length) {
            merged.add(nums1[i]);
            i++;
        }

        while (j < nums2.length) {
            merged.add(nums2[j]);
            j++;
        }
        int size = merged.size();
        if (size % 2 == 0) { // even sized list
            return (merged.get(size / 2 - 1) + merged.get(size / 2)) / 2.0;
        } else { // odd sized list
            return merged.get(size / 2);
        }
    }
}
```


### 2. Better Approach

We can get rid of the third list that we created in the first solution. This is because, on further observation, we realized that we only needed the two middle elements in the merged list in order to solve this problem. 

If the merged list size was odd, we simply returned `n/2`, and if it was even, we returned `(n/2 + n/2 - 1) / 2`. To optimize the space used in the previous approach, we can eliminate the third array used to store the final merged result. After closer examination, we realize that we only need the two middle elements at indices `(n1+n2)/2` and `((n1+n2)/2)-1`, rather than the entire merged array, to solve the problem effectively.

We will stick to the same basic approach, but instead of storing elements in a separate array, we will use a counter called 'count' to represent the imaginary third array's index. As we traverse through the arrays, when 'count' reaches either index `(n1+n2)/2` or `((n1+n2)/2)-1`, we will store that particular element. This way, we can achieve the same goal without using any extra space.

#### Algorithm:

1. **Identify Required Indices**:
   - Let `index2 = (n1+n2)/2` and `index1 = ((n1+n2)/2)-1`.
   - Initialize a counter called `count` to 0.

2. **Set Up Pointers**:
   - Use two pointers `i` and `j` where `i` points to the first element of `nums1` and `j` points to the first element of `nums2`.

3. **Traverse Both Arrays**:
   - Use a while loop (`while(i < nums1.length && j < nums2.length)`):
     - Compare `nums1[i]` and `nums2[j]`.
     - Select the smaller element, increment the respective pointer (`i` or `j`), and increment `count`.
     - Check if `count` matches `index1` or `index2`. If so, store the respective element.

4. **Handle Remaining Elements**:
   - After the main loop, handle leftover elements in `nums1` or `nums2`. Continue checking `count` for `index1` or `index2` and increment accordingly.

5. **Calculate the Median**:
   - Call the elements at `index1` and `index2` as `element1` and `element2` respectively.
     - If the total length `(n1+n2)` is even:
       - Median = `(element1 + element2) / 2.0`.
     - If the total length `(n1+n2)` is odd:
       - Median = `element2`.

6. **Return the Median**:
   - Return the calculated median value.

Below is the code implementation:

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int index1 = (n1 + n2 - 1) / 2;
        int index2 = (n1 + n2) / 2;

        int i = 0, j = 0, count = 0;
        int element1 = 0, element2 = 0;

        while (i < n1 && j < n2) {
            int smaller;
            if (nums1[i] <= nums2[j]) {
                smaller = nums1[i];
                i++;
            } else {
                smaller = nums2[j];
                j++;
            }

            if (count == index1) element1 = smaller;
            if (count == index2) element2 = smaller;
            count++;
        }

        while (i < n1) {
            if (count == index1) element1 = nums1[i];
            if (count == index2) element2 = nums1[i];
            i++; count++;
        }

        while (j < n2) {
            if (count == index1) element1 = nums2[j];
            if (count == index2) element2 = nums2[j];
            j++; count++;
        }

        if ((n1 + n2) % 2 == 0) {
            return (element1 + element2) / 2.0;
        } else {
            return element2;
        }
    }
}
```

