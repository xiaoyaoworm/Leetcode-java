//http://xiaoyaoworm.com/blog/2015/04/14/%E6%96%B0leetcode-hashtable-1-valid-sudoku/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<boolean[]> rowList = new ArrayList<boolean[]>();
        ArrayList<boolean[]> colList = new ArrayList<boolean[]>();
        ArrayList<boolean[]> blkList = new ArrayList<boolean[]>();
         
        for(int i = 0; i < 9; i++){
            rowList.add(new boolean[9]);
            colList.add(new boolean[9]);
            blkList.add(new boolean[9]);
        }
         
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j]=='.') continue;
                int c = board[i][j]-'1';
                 
                if(rowList.get(j)1 == true || colList.get(i)1 == true || blkList.get(i/3*3+j/3)1 == true){
                    return false;
                } else{
                    rowList.get(j)1 = true;
                    colList.get(i)1 = true;
                    blkList.get(i/3*3+j/3)1 = true;
// here must be divide then multiple, 2/3 will become 0
                }
            }
        }
        return true;
    }
}