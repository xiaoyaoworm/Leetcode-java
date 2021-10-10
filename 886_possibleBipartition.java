class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[][] graph = new int[n][n];
        for(int[] dislike: dislikes){
            graph[dislike[0]-1][dislike[1]-1] = 1; //DO NOT FORGET minus 1
            graph[dislike[1]-1][dislike[0]-1] = 1;
        }
        // -1 means not visited, 0 means group A, 1 means group B
        int[] group = new int[n];
        Arrays.fill(group, -1);
        for(int i = 0; i < n; i++){
            if(group[i] == -1 && !dfs(n, graph, group, i, 1)){
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int n, int[][] graph, int[] group, int index, int g){
        group[index] = g;
        for(int i = 0; i < n; i++){
            if(graph[index][i] == 1){
                if(group[i] == g) return false;
                if(group[i] == -1 && !dfs(n, graph, group, i, 1-g)){
                    return false;
                }
            }
        }
        return true;
    }
}