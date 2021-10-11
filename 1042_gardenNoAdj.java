//COPY from https://leetcode.com/problems/flower-planting-with-no-adjacent/discuss/327959/Lee's-Solution-with-Comments
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        //Create a graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        //... via adjacency list
        for (int i = 0; i < n; i++) graph.put(i, new HashSet<>());
        //Add the edges 
        for (int[] path : paths){
            int x = path[0] - 1; //Due to 1-based indexing 
            int y = path[1] - 1; //Due to 1-based indexing
            //Undirected edge
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        //Here is our solution vector where res[i] represents color of garden i+1
        int[] res = new int[n];
        
        //Now run graph painting algorithm
        
        //For each garden
        for (int i = 0; i < n; i++){
            int[] colors = new int[5]; //Use 5 instead of 4 so we can easily use 1-based indexing of the garden colors
            for (int nei : graph.get(i)){
                colors[res[nei]] = 1; //Mark the color as used if neighbor has used it before.
            }
            //Now just use a color that has not been used yet
            for (int c = 4; c >= 1; c--){
                if (colors[c] != 1) //colors[c] == 0 => the color has not been used yet,
                    res[i] = c; //so let's use that one
            }
        }   
        return res;
    }
}