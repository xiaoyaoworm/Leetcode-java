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
    

这道是求2D Matrix（0，1）里面的最大岛屿面积（1）

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by leon on 7/6/16.
 */
public class Solutions {

    public int getArea(int[][] grid){
        if(grid == null || grid.length == 0) return 0;
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int temp = bfs(grid, i, j);
                    result = Math.max(temp,result);
                }

            }
        }
        return result;
    }

    public int bfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        int temp = 0;
        Queue<Point> queue = new LinkedList<Point>();
        if(grid[i][j] == 1){
            queue.add(new Point(i,j));
            temp++;
            grid[i][j] = -1;
        }

        while(!queue.isEmpty()){
            Point cur = queue.remove();
            int x = cur.x;
            int y = cur.y;

            if(x>0 && grid[x-1][y]==1){
                queue.add(new Point(x-1,y));
                temp++;
                grid[x-1][y] = -1;
            }

            if(x<m-1 && grid[x+1][y] == 1){
                queue.add(new Point(x+1,y));
                temp++;
                grid[x+1][y] = -1;
            }

            if(y>0 && grid[x][y-1]== 1){
                queue.add(new Point(x,y-1));
                temp++;
                grid[x][y-1] = -1;
            }

            if(y<n-1 && grid[x][y+1] == 1){
                queue.add(new Point(x,y+1));
                temp++;
                grid[x][y+1] = -1;
            }
        }
        return temp;
    }


    public class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] area = new int[4][4];
        area[0] = new int[]{0,1,1,0};
        area[1] = new int[]{0,0,0,1};
        area[2] = new int[]{0,1,1,0};
        area[3] = new int[]{1,0,1,1};

        System.out.println(new Solutions().getArea(area));
    }
}
    