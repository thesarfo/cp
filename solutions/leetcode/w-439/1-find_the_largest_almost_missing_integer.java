class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int i = 0; i <= nums.length - k; i++) {
            int[] subarray = new int[k];
            for (int j = 0; j < k; j++) subarray[j] = nums[i + j];
            
            
            boolean[] seen = new boolean[51]; 
            for (int num : subarray) {
                if (!seen[num]) {
                    seen[num] = true;
                    countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                }
            }
        }
        
        int largestMissing = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1 && entry.getKey() > largestMissing) largestMissing = entry.getKey();
        }
        
        return largestMissing;
    }
}
