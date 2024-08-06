class Solution{
    static long factorial(int N){
        // code here
        if (N == 0){
            return 1;
        }
        return N * factorial(N - 1);
    }
}