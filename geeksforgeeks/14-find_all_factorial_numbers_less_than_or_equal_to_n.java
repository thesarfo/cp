class Solution {
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        ArrayList<Long> factorials = new ArrayList<>();
        
        long fact = 1;
        long i = 1;
        
        while (fact <= n) {
            factorials.add(fact);
            i++;
            fact *= i;
        }
        
        return factorials;
    }
}