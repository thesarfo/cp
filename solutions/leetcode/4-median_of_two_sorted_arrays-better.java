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