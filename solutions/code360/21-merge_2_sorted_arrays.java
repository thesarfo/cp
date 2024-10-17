public class Solution {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        // Write your code here.
        int m = a.length;
        int n = b.length;

        int left = m - 1;  
        int right = 0;     

        
        while (left >= 0 && right < n) {
            if (a[left] > b[right]) {
                long temp = a[left];
                a[left] = b[right];
                b[right] = temp;

                left--;
                right++;
            } else {
                break;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }
}