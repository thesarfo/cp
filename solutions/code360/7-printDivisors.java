public class Solution{
    public static List< Integer > printDivisors(int n) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++){
            if (n % i == 0){
                res.add(i);
            }
        }
        return res;
    }
}