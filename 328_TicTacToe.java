//Very smart solution
//we only need to check current row, current col, diag and antiDiag
//for player1, we add the value +1, for player2, we add the value -1
//if any one of those four reaches (Math.abs!!!) n, this means successfully.
//otherwise return 0, game continues.
public class TicTacToe {
    int n;
    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.diag = 0;
        this.antiDiag = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player == 1? 1 : -1;
        
        rows[row]+=add;
        cols[col]+=add;
        
        if(row == col) diag+=add;
        if(row+col == n-1) antiDiag+=add;
        
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n) return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */


//Naive solutions. O(n) solution, check row, col, diag 3n.
public class TicTacToe {
    
    char[][] board;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new char[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player == 1) board[row][col] = 'X';
        else if(player == 2) board[row][col] = 'O';
        if(checkWin(row, col, player)) return player;
        else return 0;
    }
    
    public boolean checkWin(int row, int col, int player){
        char symbol = 'X';
        if(player == 2) symbol = 'O';
        boolean res = false;
        for(int i = 0; i < board.length; i++){
            if(board[row][i] != symbol) break;
            if(i == board.length-1) return true;
        }
        for(int i = 0; i < board.length; i++){
            if(board[i][col] != symbol) break;
            if(i == board.length-1) return true;
        }
        for(int i = 0; i < board.length; i++){
            if(board[i][i] != symbol) break;
            if(i == board.length-1) return true;
        }
        for(int i = 0; i < board.length; i++){
            if(board[i][board.length-1-i] != symbol) break;
            if(i == board.length-1) return true;
        }
        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */