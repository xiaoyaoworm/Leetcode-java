//从右上角那个点开始扫。如果找到target返回它。
//如果发现那个点比target大，整个这一列可以舍弃。col--
//如果发现那个点比target小，整个这一行可以舍弃。row++;
//时间复杂度O(m+n)

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int row = 0;
        int col = matrix[0].length-1;
        while(col >= 0 && row < matrix.length){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}