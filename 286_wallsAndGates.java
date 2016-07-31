public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    public void dfs(int[][] rooms, int i, int j, int num){
        int m = rooms.length;
        int n = rooms[0].length;
        if(i < 0 || j < 0 || i>= m || j>= n || rooms[i][j] == -1 || num > rooms[i][j]) return;
        
        rooms[i][j] = num;
        dfs(rooms, i+1, j, num+1);
        dfs(rooms, i-1, j, num+1);
        dfs(rooms, i, j-1, num+1);
        dfs(rooms, i, j+1, num+1);
        
    }
}