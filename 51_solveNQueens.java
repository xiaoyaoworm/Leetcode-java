public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }
    
    public void dfs(char[][] board, int col, List<List<String>> res){
        int n = board.length;
        if(col == n){
            List<String> list = convert(board);
            res.add(list);
            return;
        }
        for(int i = 0; i < n; i++){
            if(isValid(board, i, col)){
                board[i][col] = 'Q';
                dfs(board, col+1, res);
                board[i][col] = '.';
            }
        }
    }
    
    public boolean isValid(char[][] board, int x, int y){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < y; j++){ // y is col, so this is the end.
                if(board[i][j] == 'Q' && (x == i || y-j == x-i || x+y == i+j)) return false;
                // same row: x == i
                // slope = 1: y-j = x-i
                // slope = -1: y-j = -1*(x-i) --> x+y = i+j
            }
        }
        return true;
    }
    
    private List<String> convert(char[][] board){
        int n = board.length;
        StringBuffer sb = null;
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < n; i++){
            sb = new StringBuffer();
            for(int j = 0; j < n; j++){
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }
}