class Solution {
    public List<String> generateParenthesis(int n) {
        // for i : n
        // dp[n] = '(' + dp[i] + ')' + dp[n - 1 - i]
        List<List<String>> dp = new ArrayList<>();
        dp.add(Collections.singletonList(""));

        for(int i = 1; i <= n; i++){
            List<String> curr = new ArrayList<>();
            for(int j = 0; j < i; j++){
                for(String beg : dp.get(j)){
                    for(String end : dp.get(i - 1- j)){
                        curr.add("(" + beg + ")" + end);
                    }
                }
            }
            dp.add(curr);
        }

       return dp.get(n);
    }
}