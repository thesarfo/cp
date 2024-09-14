int consecutiveOnes(vector<int>& arr){
    //Write your code here.
    int count = 0;
    int maxi = 0;
    int n = arr.size();

    for(int i = 0; i < n; i++){
        if (arr[i] == 1){
            count++;
            maxi = std::max(count, maxi);
        } else{
            count = 0;
        }
    }
    return maxi;
}