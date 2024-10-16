class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int maxLength = 0;
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += arr[i];
            
            if(sum == 0){
                maxLength = i + 1;
            }
            
            if(prefixSumMap.containsKey(sum)){
                maxLength = Math.max(maxLength, i - prefixSumMap.get(sum));
            } else{
                prefixSumMap.put(sum, i);
            }
        }
        return maxLength;
    }
}