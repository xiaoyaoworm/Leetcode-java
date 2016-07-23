public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){
                        if(isValid(board,i,j,k)){
                            board[i][j] = k;
                            if(solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int i, int j, char c){
        for(int k = 0; k < 9; k++){
            if(board[i][k] == c || board[k][j] == c) return false;
        }
        
        for(int x= i/3*3; x< i/3*3+3; x++){
            for(int y = j/3*3; y < j/3*3+3; y++){
                if(board[x][y] == c) return false;
            }
        }
        return true;
    }
}