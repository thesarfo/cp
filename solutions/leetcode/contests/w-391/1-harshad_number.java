class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = sumOfDigits(x);
        if (x % sum == 0) {
            return sum;
        } else {
            return -1;
        }
    }
    
    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}