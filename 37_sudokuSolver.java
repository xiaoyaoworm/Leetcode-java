//http://xiaoyaoworm.com/blog/2015/04/15/%E6%96%B0leetcode-hashtable-3-sudoku-solver/

public class Solution {
    public void solveSudoku(char[][] board) {
        if(board== null || board.length == 0) return;
        helper(board);
    }
     
    public boolean helper(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length ; j++){
                if(board[i][j]=='.'){
                    for(char c = '1'; c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j] = c;
                            if(helper(board)){
                                return true;
                            } else{
                                board[i][j] = '.'; //roll back!!!
                            }
                        }
                    }
                    return false;// if check this place cannot be filled by 1~9, return false
                }
            }
        }
        return true;
    }
     
    public boolean isValid(char[][] board, int i, int j, char c){
        for(int m = 0; m < 9; m++){
            if(board[m][j] == c){
                return false;
            }
        }
         
        for(int n = 0; n < 9; n++){
            if(board[i][n] == c){
                return false;
            }
        }
         
        for(int row = i/3*3; row < i/3*3+3; row++){
            for(int col = j/3*3; col < j/3*3+3; col++){
                if(board[row][col] == c){
                    return false;
                }
            }
        }
        return true;
    }
}