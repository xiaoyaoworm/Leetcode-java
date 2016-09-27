//Same as Spiral Matrix I, easy understanding
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        
        int num = 1;
        while(rowStart<= rowEnd && colStart <= colEnd){
            for(int i = colStart; i <= colEnd; i++){
                res[rowStart][i] = num;
                num++;
            }
            rowStart++;
            
            for(int i = rowStart; i<= rowEnd; i++){
                res[i][colEnd] = num;
                num++;
            }
            colEnd--;
            
            if(rowStart<= rowEnd){
                for(int i = colEnd; i>= colStart; i--){
                    res[rowEnd][i] = num;
                    num++;
                }
                rowEnd--;
            }
            
            if(colStart<= colEnd){
                for(int i = rowEnd; i>= rowStart; i--){
                    res[i][colStart] = num;
                    num++;
                }
                colStart++;
            }
        }
        return res;
    }
}

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int x = 0;
        int y = 0;
        int step = 0;
        int k = 1;
        while(k<= n*n){
            while(y+step<n){ // Be careful for all the conditions!!!!
                result[x][y] = k;
                y++;
                k++;
            }
            y--;
            x++;
            while(x+step<n){
                result[x][y] = k;
                x++;
                k++;
            }
            x--;
            y--;
            while(y>=step){
                result[x][y] = k;
                y--;
                k++;
            }
            y++;
            x--;
            step++; //Most Important!!!!!!!!!!!!
            while(x>=step){
                result[x][y] = k;
                x--;
                k++;
            }
            x++;
            y++;
        }
        return result;
    }
}