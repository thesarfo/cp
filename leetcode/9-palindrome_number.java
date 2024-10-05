class Solution {
    public int reverse(int num){
        int rev = 0;
        while (num > 0){
            rev = (rev * 10) + (num % 10);
            num /= 10;
        }
        return rev;
    }
    public boolean isPalindrome(int x) {
        int y = reverse(x);
        return x == y;
    }
}