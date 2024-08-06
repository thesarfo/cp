class Solution {
    long sumOfSeries(long n) {
        // code here
        long res = 0;
        for(long i = 1; i <= n; i++){
            res += i * i * i;
        }
        return res;
    }
}

// recursive solution
class Solution {
    long sumOfSeries(long n) {
        // code here
        if (n == 0){
            return 0;
        }
        return n*n*n + sumOfSeries(n-1);
    }
}