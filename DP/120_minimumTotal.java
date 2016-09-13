//Two ways:
//This is bottom up.

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for(int i = 0; i < n; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        
        for(int i = n-2; i>=0; i--){
            for(int j = 0; j <= i; j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}