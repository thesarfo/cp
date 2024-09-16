class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] firstHalf = Arrays.copyOfRange(nums, 0, n);
        int[] secondHalf = Arrays.copyOfRange(nums, n, nums.length);
        
        int[] finalArr = new int[nums.length];
        
        int k = 0; 
        for (int i = 0; i < n; i++) {
            finalArr[k++] = firstHalf[i];  
            finalArr[k++] = secondHalf[i];
        }
        
        return finalArr;
    }
}
