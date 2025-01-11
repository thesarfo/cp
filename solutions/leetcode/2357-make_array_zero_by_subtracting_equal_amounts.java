class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> uniquePositiveNumbers = new HashSet<>();
        
        for (int num : nums) {
            if (num > 0) {
                uniquePositiveNumbers.add(num);
            }
        }
        
        return uniquePositiveNumbers.size();
    }
}
