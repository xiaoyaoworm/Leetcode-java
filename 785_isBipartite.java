class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                Stack<Integer> stack = new Stack(); //Using stack means this is DFS!!! using queue means this is BFS!!!
                stack.push(i);
                color[i] = 0; //First col
                
                while(!stack.isEmpty()){
                    int cur = stack.pop();
                    for(int nei: graph[cur]){
                        if(color[nei] == -1){
                            stack.push(nei);
                            color[nei]=1-color[cur];
                        } else if(color[nei] == color[cur]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}