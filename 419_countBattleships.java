//非常巧妙的解法！
public class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.') continue;
                if(i-1 >= 0 && board[i-1][j] == 'X') continue;
                if(j-1 >= 0 && board[i][j-1] == 'X') continue;
                count++;//我们只记录top left的那个点，如果碰到是它的相邻，如上所示，跳过记录count
            }
        }
        return count;
    }
}