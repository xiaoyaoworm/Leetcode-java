//http://xiaoyaoworm.com/blog/2015/04/26/%E6%96%B0leetcode-hashtable-8-maximal-rectangle/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                maxArea = Math.max(maxArea, maxRectangle(matrix, i, j));
            }
        }
        return maxArea;
    }
     
    private int maxRectangle(char[][] matrix, int row, int col){
        int minWidth = Integer.MAX_VALUE;
        int maxArea = 0;
        for(int i = row; i < matrix.length && matrix[i][col] == '1'; i++){
            int width = 0;
            while(col+width < matrix[i].length && matrix[i][col+width]=='1'){
                width++;
            }
            if(width < minWidth){
                minWidth = width;
            }
            int area = (i+1-row)*minWidth;
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}