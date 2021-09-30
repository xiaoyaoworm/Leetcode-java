class Solution {
    int count = 0;
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int row = grid.length;
        int col = grid[0].length;
        int index = 2; // Because origianl is 0 and 1, we want use dfs to go through all island to store them in the map: use index to override the value of 1, map will store indes:size
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    dfs(grid,i,j,index);
                    map.put(index, count);
                    index++;
                    count = 0;
                }
            }
        }
        
        int max = 0; 
        //Necessary because it may happen with no 0 situation, we have to override max to be the largest island.
        for(int key: map.keySet()){
            max = Math.max(max, map.get(key));
        }
        HashSet<Integer> neighbor = new HashSet<Integer>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                //We only need to check if this is still 0, whether its for direction has some island, remove the duplicate one using set, then add those sizes together +1(change this node from 0 to 1), problem solved.
                if(grid[i][j] == 0){
                    if(i > 0 && grid[i-1][j] != 0){
                        neighbor.add(grid[i-1][j]);
                    }
                    if(j > 0 && grid[i][j-1] != 0){
                        neighbor.add(grid[i][j-1]);
                    }
                    if(i < row-1 && grid[i+1][j] != 0){
                        neighbor.add(grid[i+1][j]);
                    }
                    if(j < col-1 && grid[i][j+1] != 0){
                        neighbor.add(grid[i][j+1]);
                    }
                    int area = 1;
                    for(int nei: neighbor){
                        area+=map.get(nei);
                    }
                    neighbor.clear(); //Dont forget to clear it!!!!
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }
    
    public void dfs(int[][] grid, int x, int y, int index){
        int row = grid.length;
        int col = grid[0].length;
        if(x<0 || y<0 || x >= row || y >= col || grid[x][y]!=1) return;
        grid[x][y] = index;
        count++;
        dfs(grid,x+1,y,index);
        dfs(grid,x-1,y,index);
        dfs(grid,x,y+1,index);
        dfs(grid,x,y-1,index);
    }
}