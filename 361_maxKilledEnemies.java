public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '0'){
                    int current = kill(grid, i, j);
                    res = Math.max(current, res);
                }
            }
        }
        return res;
    }
    
    public int kill(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i >= m || i < 0 || j >= n || j< 0) return 0;
        int res = 0;
        for(int k = i; k < m; k++){
            if(grid[k][j]== 'W') break;
            if(grid[k][j] == 'E') res++;
        }
        for(int k = i; k >= 0; k--){
            if(grid[k][j] == 'W') break;
            if(grid[k][j] == 'E') res++;
        }
        for(int k = j; k < n; k++){
            if(grid[i][k] == 'W') break;
            if(grid[i][k] == 'E') res++;
        }
        for(int k = j; k >= 0; k--){
            if(grid[i][k] == 'W') break;
            if(grid[i][k] == 'E') res++;
        }
        return res;
    }
}

//To be continued还有更优解