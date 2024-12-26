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
        if (size % 2 == 0) {
            return (res.get(size / 2 - 1) + res.get(size / 2)) / 2.0;
        } else {
            return res.get(size / 2);
        }
    }
}