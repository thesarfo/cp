class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++){
            if(i == 0){
                stack.push(chars[i]);
            }else if(chars[i] != '*'){
                stack.push(chars[i]);
            }else{
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
