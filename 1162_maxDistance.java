class Solution {
    public class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int maxDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        
        Queue<Node> queue = new LinkedList<Node>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    queue.add(new Node(i,j));
                    visited[i][j] = true;
                }
            }
        }
        int level = -1;//All 0 cases, it would return -1, all 1 cases it would return 0
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node current = queue.remove();
                int x = current.x;
                int y = current.y;
                if(x-1 >= 0 && grid[x-1][y] == 0 && !visited[x-1][y]){
                    queue.add(new Node(x-1, y));
                    visited[x-1][y] = true;
                }
                if(y-1 >= 0 && grid[x][y-1] == 0 && !visited[x][y-1]){
                    queue.add(new Node(x, y-1));
                    visited[x][y-1] = true;
                }
                if(x+1 <row && grid[x+1][y] == 0 && !visited[x+1][y]){
                    queue.add(new Node(x+1,y));
                    visited[x+1][y] = true;
                }
                if(y+1 <col && grid[x][y+1] == 0 && !visited[x][y+1]){
                    queue.add(new Node(x,y+1));
                    visited[x][y+1] = true;
                }
            }
            level++;
        }
        return level <= 0 ? -1: level;
    }
}