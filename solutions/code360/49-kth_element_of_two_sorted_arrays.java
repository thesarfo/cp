import java.util.ArrayList;
public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        // Write your coder here
        ArrayList<Integer> res = new ArrayList<>();
        int l = 0, r = 0;

        while(l < arr1.size() && r < arr2.size()){
            if(arr1.get(l) <= arr2.get(r)){
                res.add(arr1.get(l));
                l++;
            }else{
                res.add(arr2.get(r));
                r++;
            }
        }

        while(l < arr1.size()){
            res.add(arr1.get(l));
            l++;
        }

        while(r < arr2.size()){
            res.add(arr2.get(r));
            r++;
        }
        return res.get(k - 1);
    }
}