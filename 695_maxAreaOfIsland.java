class Solution {
    int num = 0;
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    num = 0;
                    dfs(grid, i, j);
                    max = Math.max(max, num);
                }
            }
        }
        return max;
    }
    
    public void dfs(int[][] grid, int i, int j){
        int row = grid.length;
        int col = grid[0].length;
        if(i<0 || j <0 || i>=row || j >=col || grid[i][j] != 1) return;
        num++;
        grid[i][j] = 2;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}