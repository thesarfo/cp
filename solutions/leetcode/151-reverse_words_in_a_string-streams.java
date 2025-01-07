class Solution {
    public String reverseWords(String s) {
        return Arrays.stream(s.trim().split("\\s+")) 
                     .collect(Collectors.toList())  
                     .stream()                       
                     .sorted((w1, w2) -> -1)         
                     .collect(Collectors.joining(" ")); 
    }
}