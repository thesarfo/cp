class Solution {
  public:
    string armstrongNumber(int n) {
        // code here
        int dup = n;
        int sum = 0;

        while(n > 0){
            int lastDigit = n % 10;
            sum = sum + (lastDigit * lastDigit * lastDigit);
            n = n / 10;
        }
        if(sum == dup){
            return "true";
        } else{
            return "false";
        }
    }
};