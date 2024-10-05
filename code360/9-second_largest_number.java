import java.util.Arrays;

public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.
        Arrays.sort(a);
        int []b = new int[2];

        int max = a[a.length - 1];
        int smax = a[a.length - 2];
        int sm = a[1];

        b[0] = smax;
        b[1] = sm;

        return b;

    }
}