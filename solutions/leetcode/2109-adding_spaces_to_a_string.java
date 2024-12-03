class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder();
        int prev = 0;

        for(int space : spaces){
            res.append(s.substring(prev, space));
            res.append(" ");
            prev = space;
        }
        res.append(s.substring(prev));
        return res.toString();
    }
}