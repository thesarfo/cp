class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> union = new ArrayList<>();

        int i = 0, j = 0;

        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                union.add(nums1[i]);
                i++;
            } else{
                union.add(nums2[j]);
                j++;
            }
        }

        while(i < m){
            union.add(nums1[i]);
            i++;
        }

        while(j < n){
            union.add(nums2[j]);
            j++;
        }

        for(int k = 0; k < union.size(); k++){
            nums1[k] = union.get(k);
        }


    }
}