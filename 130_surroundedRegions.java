用DFS去递归解，

public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                if(i == 0 || i == row-1 || j == 0 || j == col-1){
                    if(board[i][j] == 'O'){
                        dfs(board,i,j);
                    }
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'Z') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
    
    public void dfs(char[][] board, int x, int y){
        int row = board.length;
        int col = board[0].length;
        board[x][y] = 'Z';
        if(x-1>0 && board[x-1][y] == 'O') dfs(board,x-1,y);
        if(x+1<row-1 && board[x+1][y] == 'O') dfs(board,x+1,y);
        if(y-1>0 && board[x][y-1] == 'O') dfs(board,x,y-1);
        if(y+1<col-1 && board[x][y+1]=='O') dfs(board,x,y+1);
    }
}


用BFS去解：

public class Solution {
    public class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        Queue<Pair> queue = new LinkedList<Pair>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 || i == row-1 || j == 0 || j == col-1){
                    if(board[i][j] =='O'){
                        queue.add(new Pair(i,j));
                    }
                }
            }
        }
        
        while(!queue.isEmpty()){
            Pair temp = queue.remove();
            int x = temp.x;
            int y = temp.y;
            board[x][y] = 'Z';
            
            if(x-1>0 && board[x-1][y] == 'O') queue.add(new Pair(x-1,y));
            if(x+1<row-1 && board[x+1][y] == 'O') queue.add(new Pair(x+1,y));
            if(y-1>0 && board[x][y-1] == 'O') queue.add(new Pair(x,y-1));
            if(y+1<col-1 && board[x][y+1] == 'O') queue.add(new Pair(x,y+1));
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j]=='Z') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
}