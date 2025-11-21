class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder current, int beg, int end, int n){
        if(current.length() == 2 * n){
            res.add(current.toString());
            return;
        }

        if(beg < n){
            current.append('(');
            backtrack(res, current, beg + 1, end, n);
            current.deleteCharAt(current.length() -1);
        }

        if(end < beg){
            current.append(')');
            backtrack(res, current, beg, end + 1, n);
            current.deleteCharAt(current.length() -1);
        }
    }
}