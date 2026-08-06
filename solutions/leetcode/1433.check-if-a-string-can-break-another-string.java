/*
 * @lc app=leetcode id=1433 lang=java
 *
 * [1433] Check If a String Can Break Another String
 */

// @lc code=start
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();

        Arrays.sort(s1arr);
        Arrays.sort(s2arr);
        
        boolean real = true;  
        boolean fake = true; 

        for(int i = 0; i < s1arr.length; i++){
            if(s1arr[i] < s2arr[i]){
                real = false;
            }

            if(s2arr[i] < s1arr[i]){
                fake = false;
            }

            if (!real && !fake) {
                return false;
            }
        }
        
        return real || fake;
    }
}   
// @lc code=end

