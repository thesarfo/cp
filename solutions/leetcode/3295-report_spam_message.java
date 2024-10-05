class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> banned = new HashSet<>();
        int count = 0;

        for(String b : bannedWords){
            banned.add(b);
        }

        for(String word : message){
            if(banned.contains(word)){
                count++;
            }
            if(count >= 2){
                return true;
            }
        }
        return false;
    }
}
