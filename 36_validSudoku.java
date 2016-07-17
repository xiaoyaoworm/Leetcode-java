更简洁的写法，用一个长方形划定一个区域，检测其为valid or not：
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            if(!isValid(board,0,i,8,i)) return false; //check col
            if(!isValid(board,i,0,i,8)) return false; //check row
        }
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(!isValid(board,i*3,j*3,i*3+2,j*3+2)) return false;
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int x1, int y1, int x2, int y2){
        HashSet<Character> set = new HashSet<Character>();
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
            }
        }
        return true;
    }
}


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