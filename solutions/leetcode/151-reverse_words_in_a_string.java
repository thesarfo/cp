class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        int low = 0;
        int high = words.length - 1;

        while(low < high){
            String temp = words[low];
            words[low] = words[high];
            words[high] = temp;
            low++;
            high--;
        }
        return String.join(" ", words);
    }
}