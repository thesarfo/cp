class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (result.isEmpty() || result.get(result.size() - 1) != nums1[i])
                    result.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] resultArr = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            resultArr[k] = result.get(k);
        }
        return resultArr;
    }
}