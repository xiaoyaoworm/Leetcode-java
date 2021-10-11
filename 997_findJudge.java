class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] res = new int[n+1];
        for(int[] t: trust){
            int a = t[0];
            int b = t[1];
            res[a] = -1;
            if(res[b]!= -1){
                res[b]++;
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(res[i] == n-1) return i;
        } 
        return -1;
    }
}