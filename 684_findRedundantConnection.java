class Solution {
    int[] parents;

    public int[] findRedundantConnection(int[][] edges) {
        parents = new int[2001];
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
        }
        
        for(int[] edge: edges){
            int a = find(parents, edge[0]);
            int b = find(parents, edge[1]);
            if(a!=b){
                parents[a] = b;
            } else {
                return edge;
            }
        }
        return new int[2];
    }
    
    public int find(int[] parents, int x){
        while(parents[x]!=x){
           x = parents[x];
        }
        return x;
    }

}


