//Initial this will cause O(M*N) time
//update this will take O((M-row) * (N-col)) time
//sumRegion will take O(1) time

public class NumMatrix {
    int[][] sum; // is used for saving all sum of (0,0) as top left point, (i, j) as bottom right point
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if(matrix!= null){ //Be careful matrix can be null.
            int m = matrix.length;
            if(m == 0) return; //Be careful here!!!! m can be 0.
            int n = matrix[0].length;
            this.sum = new int[m][n];
            sum[0][0] = matrix[0][0];
            for(int j = 1; j < n; j++){
                sum[0][j] = sum[0][j-1]+matrix[0][j]; //initial first row
            }
            
            for(int i = 1; i < m; i++){
                sum[i][0] = sum[i-1][0]+matrix[i][0]; //initial first col
            }
            
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    //if you draw a picture, you will notice To calculate this sum[i][j], you can use the left sum[i-1][j] and the top sum[i][j-1], 
                    // accumulate them then remove the overlap left top sum[i-1][j-1], then adding the matrix[i][j]
                    sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+matrix[i][j];
                }
            }
        }
    }

    public void update(int row, int col, int val) {
        if(matrix!= null){ //Be careful matrix can be null.
            int m = matrix.length;
            if(m == 0) return; //Be careful here!!!! m can be 0.
            int n = matrix[0].length;
            int gap = val-matrix[row][col];
            matrix[row][col] = val;
            for(int i = row; i < m; i++){ // we only need to update all sum which includes this matrix[row][col] value.
                for(int j = col; j < n; j++){
                    sum[i][j]+=gap;
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int top = 0;
        int left = 0;
        int leftTop = 0;
        if(col1-1 >= 0){// dont forget these three if conditions!!! some corner case this will be invalid and the value is 0.
            left = sum[row2][col1-1];
        }
        if(row1-1>= 0) {
            top = sum[row1-1][col2];
        }
        if(col1-1 >= 0 && row1-1 >= 0){
            leftTop = sum[row1-1][col1-1];
        }
        return sum[row2][col2] - top - left + leftTop; //Same idea as above, draw an example and easy to see.
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);