DFS:


public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    result++;
                }
            }
        }
        return result;
    }
    
    public void dfs(char[][] grid, int i, int j){
        int row = grid.length;
        int col = grid[0].length;
        if(i < 0 || j < 0 || i>= row || j >= col || grid[i][j]!= '1') return;
        grid[i][j] = 'Y';
        
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
    
    
    
}


BFS:
public class Solution {
    public class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int numIslands(char[][] grid) {
        int result = 0;
        if(grid == null || grid.length == 0) return result;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    
    public void bfs(char[][] grid, int i, int j){
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(i,j));
        grid[i][j] = 'Y';
        
        while(!queue.isEmpty()){
            Pair temp = queue.remove();
            int x = temp.x;
            int y = temp.y;
            if(x>=1 && grid[x-1][y] == '1'){
                queue.add(new Pair(x-1,y));
                grid[x-1][y] = 'Y';
            }
            if(x<row-1 && grid[x+1][y] == '1'){
                queue.add(new Pair(x+1,y));
                grid[x+1][y] = 'Y';
            }
            if(y>=1 && grid[x][y-1] == '1'){
                queue.add(new Pair(x,y-1));
                grid[x][y-1] = 'Y';
            }
            if(y < col-1 && grid[x][y+1] == '1'){
                queue.add(new Pair(x,y+1));
                grid[x][y+1] = 'Y';
            }
        }
    }
    
    
}