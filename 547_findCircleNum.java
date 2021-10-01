class Solution {
    public int findCircleNum(int[][] isConnected) {
        //row must equals to col because they are both cities' number
        int[] visited = new int[isConnected.length];
        int count = 0;
        for(int i = 0; i < isConnected.length; i++){
            if(visited[i] == 0){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int[][] isConnected, int[] visited, int i){
        for(int j = 0; j < isConnected.length; j++){
            if(visited[j] == 0 && isConnected[i][j] == 1){
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }
}