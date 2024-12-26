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
        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0;

        while(l < nums1.length && r < nums2.length){
            if(nums1[l] <= nums2[r]){
                res.add(nums1[l]);
                l++;
            }else{
                res.add(nums2[r]);
                r++;
            }
        }
        while (l < nums1.length) {
            res.add(nums1[l]);
            l++;
        }

        while (r < nums2.length) {
            res.add(nums2[r]);
            r++;
        }
        int size = res.size();
        if (size % 2 == 0) { // even sized list
            return (res.get(size / 2 - 1) + res.get(size / 2)) / 2.0;
        } else { // odd sized list
            return res.get(size / 2);
        }
    }
}
```