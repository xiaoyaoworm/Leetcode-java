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