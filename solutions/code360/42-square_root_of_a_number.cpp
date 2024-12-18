int floorSqrt(int n)
{
    int ans = 1;
    // Write your code here.
    for(int i = 1; i <= n; i++){
        if(i * i > n){
            break;
        }else{
            ans = i;
        }
    }
    return ans;
}
