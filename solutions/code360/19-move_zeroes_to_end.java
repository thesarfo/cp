import java.util.ArrayList;

public class Solution {
        public static int[] moveZeros(int n, int []a) {
        // Write your code here.
        ArrayList<Integer> withOut = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(a[i] != 0){
                withOut.add(a[i]);
            }
        }

        int numZeros = n - withOut.size();

        for(int i = 0; i < numZeros; i++){
            withOut.add(0);
        }
        
        for(int i = 0; i < withOut.size(); i++){
            a[i] = withOut.get(i);
        }

        return a;
    }
}