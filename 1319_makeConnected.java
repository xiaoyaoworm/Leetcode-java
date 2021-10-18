class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] parents = new int[n];
        int extra = 0;
        int group = 0;
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        
        
        for(int[] edge: connections){
            if(union(parents, edge[0], edge[1])){
                extra++;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(find(parents,i) == i) group++; //find whehter index still holding same value, means one group
        }
        
        if(extra >= group-1) return group-1;
        else return -1;
    }
    
    public boolean union(int[] parents, int x, int y){
        int a = find(parents, x);
        int b = find(parents, y);
        if(a == b) return true; //find the ring so extra++
        parents[a] = b;
        return false;
    }
    
    public int find(int[] parents, int x){
        while(x!=parents[x]){
            x = parents[x];
        }
        return x;
    }
}
