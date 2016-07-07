public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colA = A[0].length;
        int colB = B[0].length;
        
        int[][] result = new int[rowA][colB];
        
        for(int i = 0; i < rowA; i++){
            for(int k = 0; k < colA; k++){
                if(A[i][k]!=0){
                    for(int j = 0; j < colB; j++){
                        if(B[k][j]!=0){
                            result[i][j] += A[i][k]*B[k][j];
                        }
                    }
                }
            }
        }
        return result;
    }
}