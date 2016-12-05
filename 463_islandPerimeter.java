public class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){ //dont forget
                    res+=checkAroundWater(grid, i, j);
                }
            }
        }
        return res;
    }
    
    public int checkAroundWater(int[][] grid, int i, int j){
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        if(i-1 < 0 || grid[i-1][j] == 0) res++;
        if(j-1 < 0 || grid[i][j-1] == 0) res++;
        if(i+1 >= m || grid[i+1][j] == 0) res++;
        if(j+1 >= n || grid[i][j+1] == 0) res++;
        
        return res;
    }
}