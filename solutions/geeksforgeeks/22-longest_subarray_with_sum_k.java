public int lenOfLongSubarr(int[] A, int N, int K) {
    // HashMap to store prefix sums and their first occurrence
    HashMap<Integer, Integer> preSumMap = new HashMap<>();
    int maxLen = 0;
    int sum = 0;
    
    for (int i = 0; i < N; i++) {
        sum += A[i];  // Update the running sum
        
        // If the sum from the start up to the current index equals K
        if (sum == K) {
            maxLen = i + 1;  // The subarray is from the start to the current index
        }
        
        // Check if there's a subarray that sums to K
        int rem = sum - K;
        if (preSumMap.containsKey(rem)) {
            int len = i - preSumMap.get(rem);  // Calculate the length of this subarray
            maxLen = Math.max(maxLen, len);  // Update max length if it's longer
        }
        
        // Store the prefix sum if it hasn't been seen before
        if (!preSumMap.containsKey(sum)) {
            preSumMap.put(sum, i);
        }
    }
    return maxLen;
}