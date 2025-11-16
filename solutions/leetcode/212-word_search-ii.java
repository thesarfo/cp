class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; 
        String word = null;
    
    }

    private TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.word = word; 
    }
    return root;
    }


    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
       
       for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){
            dfs(board, i, j, root, res);
        }
       }

        return res;
    }



    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;

        char c = board[i][j];
        if( c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];
        if(node.word != null){
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#'; 

        dfs(board, i-1, j, node, res);
        dfs(board, i, j-1, node, res);
        dfs(board, i+1, j, node, res);
        dfs(board, i, j+1, node, res);
        board[i][j] = c;
    }
}
