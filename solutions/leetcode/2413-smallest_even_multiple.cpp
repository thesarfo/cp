class Solution {
public:
    int smallestEvenMultiple(int n) {
        int res = (n * 2) / gcd(n, 2);
        if(res % 2 == 0){
            return res;
        }
        return res;
    }

    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
};