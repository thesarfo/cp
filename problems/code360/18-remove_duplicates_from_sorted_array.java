public class Solution {
    public static int removeDuplicates(int[] arr,int n) {
        // Write your code here.
        HashSet<Integer> result = new HashSet<>();

        for(int i = 0; i < n; i++){
            result.add(arr[i]);
        }

        int idx = 0;

        for(int item: result){
            arr[idx] = item;
            idx++;
        }
        return result.size();
    }
}