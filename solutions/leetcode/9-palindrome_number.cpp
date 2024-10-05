/* this solution was correct? but caused a signed integer overflow */
class Solution {
public:
    int reverse(int y){
        int rev = 0;
        while (y > 0){
            int lastDigit = y % 10;
            rev = (rev * 10) + lastDigit;
            y = y / 10;
        }
        return rev;
    }
    bool isPalindrome(int x) {
        int y = reverse(x);
        return x == y;

    }
};

/* this solution is the optimal one, addressing all the problems of the above solution */
class Solution {
   public:
       int reverse(int y) {
           int rev = 0;
           while (y > 0) {
               if (rev > (INT_MAX - (y % 10)) / 10) {
                   // Overflow would occur if we proceed
                   return 0; // Return 0 or handle it in some other way
               }
               rev = (rev * 10) + (y % 10);
               y = y / 10;
           }
           return rev;
       }

       bool isPalindrome(int x) {
           // Negative numbers are not palindromes
           if (x < 0) return false;

           // Reverse the number
           int y = reverse(x);
           // Check if the original number and the reversed number are the same
           return x == y;
       }
   };
