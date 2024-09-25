public class Solution {
    public static int majorityElement(int []v) {
        // Write your code here
        int count = 0;
        int pme = 0;
        int n = v.length;

        for(int i = 0; i < n; i++){
            if(count == 0){
                count = 1;
                pme = v[i];
            }
            else if(v[i] == pme){
                count++;
            } else{
                count--;
            }
        }

        int vCount = 0;
        
        for(int i = 0; i < n; i++){
            if(v[i] == pme){
                vCount++;
            }
        }

        if(vCount > (n / 2)){
            return pme;
        }

        return -1;

    }
}