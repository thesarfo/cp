public class Solution {
    public static double median(int[] nums1, int[] nums2) {
        int index1 = 0, index2 = 0;
        
        int totalLength = nums1.length + nums2.length;
        int midIndex1 = totalLength / 2 - 1;
        int midIndex2 = totalLength / 2;

        int count = 0;
        int midElement1 = -1, midElement2 = -1;

        while (index1 < nums1.length && index2 < nums2.length) {
            int currentElement;
            
            if (nums1[index1] <= nums2[index2]) {
                currentElement = nums1[index1];
                index1++;
            } else {
                currentElement = nums2[index2];
                index2++;
            }

            if (count == midIndex1) midElement1 = currentElement;
            if (count == midIndex2) midElement2 = currentElement;

            count++;
        }

        while (index1 < nums1.length) {
            int currentElement = nums1[index1];
            if (count == midIndex1) midElement1 = currentElement;
            if (count == midIndex2) midElement2 = currentElement;
            count++;
            index1++;
        }

        while (index2 < nums2.length) {
            int currentElement = nums2[index2];
            if (count == midIndex1) midElement1 = currentElement;
            if (count == midIndex2) midElement2 = currentElement;
            count++;
            index2++;
        }

        if (totalLength % 2 == 1) {
            return (double) midElement2;
        }

        return (double) (midElement1 + midElement2) / 2.0;
    }
}
