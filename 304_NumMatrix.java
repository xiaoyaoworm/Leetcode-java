//Simplified 308. Range Sum Query 2D - Mutable questions!!!
//Idea are the same, 308 only adds one update function.
public class NumMatrix {
    int[][] matrix;
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if(matrix == null) return;
        int m = matrix.length;
        if(m == 0) return;
        int n = matrix[0].length;
        sum = new int[m][n];
        
        sum[0][0] = matrix[0][0];
        for(int i = 1; i < m; i++){
            sum[i][0] = sum[i-1][0]+matrix[i][0];
        }
        
        for(int j = 1; j < n; j++){
            sum[0][j] = sum[0][j-1]+matrix[0][j];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                sum[i][j] = sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int top = 0;
        int left = 0;
        int topLeft = 0;
        if(row1 -1 >= 0){
            top = sum[row1-1][col2];
        }
        if(col1 -1 >= 0){
            left = sum[row2][col1-1];
        }
        if(row1 -1 >= 0 && col1 -1 >=0){
            topLeft = sum[row1-1][col1-1];
        }
        return sum[row2][col2] - top - left+ topLeft;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);