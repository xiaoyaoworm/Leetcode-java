新解法 更好理解：

public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null) return;
        int m = matrix.length;
        //symetrically swap: [i][j] with [j][i]
        for(int i = 0; i < m; i++){
            for(int j = i; j < m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // if clock 90degree: change half of the x: [i][j] with [m-1-i][j]
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-1-j];
                matrix[i][m-1-j] = temp;
            }
        }
    }
}

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int half = n/2;
        if(n%2==1) half++;
        for(int i = 0; i < half; i++){
            for(int j = i; j < n-1-i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}