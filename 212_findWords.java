public class Solution {
        public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrieNode(words);
        List<String> res = new ArrayList<String>();
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(board, root, i, j, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, TrieNode node, int i, int j, List<String> res){
        int m = board.length;
        int n = board[0].length;
        char c = board[i][j];
        if(c == '*' || node.children[c-'a'] == null) return;

        node = node.children[c-'a'];
        if(node.word!= null){ //find one
            res.add(node.word);
            node.word = null; // de-duplicate!!!!
        }

        board[i][j] = '*';
        if (i > 0) dfs(board,node, i - 1, j , res); // write here can get rid of lots of trouble later.
        if (j > 0) dfs(board, node, i, j - 1, res);
        if (i < m-1) dfs(board, node, i + 1, j, res);
        if (j < n-1) dfs(board, node, i, j + 1,res);
        board[i][j] = c;//backtracking!!
    }

    public TrieNode buildTrieNode(String[] words){
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode run = root;
            int i = 0;
            while(i < word.length()){
                char c = word.charAt(i);
                if(run.children[c-'a'] == null) run.children[c-'a'] = new TrieNode();
                run = run.children[c-'a'];
                i++;
            }
            run.word = word;
        }
        return root;
    }

    public class TrieNode{
        String word;
        TrieNode[] children;

        public TrieNode(){
            this.word = null;
            this.children = new TrieNode[26];
        }
    }
}