public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        
        int res = 0;
        for(int[] edge: edges){
            int x = find(arr, edge[0]);
            int y = find(arr, edge[1]);
            if(x != y){
                arr[x] = y;
                n--;
            }
        }
        return n;
    }
    
    public int find(int[] arr, int i){
        if(arr[i] == -1) return i;
        return find(arr, arr[i]);
    }
}