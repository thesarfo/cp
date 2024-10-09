class Solution{
    public:
    int lenOfLongSubarr(int A[], int N, int K) 
    { 
        // Complete the function
        unordered_map<int, int> preSumMap;
        int maxLen = 0;
        int sum = 0;
        
        for(int i = 0; i < N; i++){
            sum += A[i];  
            
            if(sum == K){ 
                maxLen = i + 1;
            }
            
            int rem = sum - K;  
            if(preSumMap.find(rem) != preSumMap.end()){
                int len = i - preSumMap[rem];
                maxLen = max(maxLen, len);
            }
            
            if(preSumMap.find(sum) == preSumMap.end()){
                preSumMap[sum] = i;
            }
        }
        return maxLen;
    } 

};