class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length == 0) return new int[0][0];
        if (image[sr][sc] == newColor) return image;//skip no color change situation
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image; 
    }
    
    public void dfs(int[][] image, int i, int j, int originalColor, int newColor){
        int row = image.length;
        int col = image[0].length;
        if(i < 0 || j < 0 || i >= row || j >= col || image[i][j] != originalColor) return;
        image[i][j] = newColor;
        dfs(image, i+1,j, originalColor, newColor);
        dfs(image, i-1,j, originalColor, newColor);
        dfs(image, i,j+1, originalColor, newColor);
        dfs(image, i,j-1, originalColor, newColor);
    }
}