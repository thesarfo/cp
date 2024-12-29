public class Solution {
    public static int missingK(int[] vec, int n, int k) {
        // Write your code here.
        int low = 0, high = vec.length-1;

        while(low <= high){
            int mid = (low + high) / 2;

            int missingNumbers = vec[mid] - (mid + 1);

            if(missingNumbers < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            
        }
        return k + high + 1;
    }
}
