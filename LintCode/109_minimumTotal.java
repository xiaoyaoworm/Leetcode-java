//Top to Bottom
//1607ms
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        
        if(triangle == null || triangle.length == 0) return 0;
        if(triangle[0] == null || triangle[0].length == 0) return 0;
        
        int m = triangle.length;
        int[][] dp = new int[m][m];
        
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0]+triangle[i][0];
            dp[i][i] = dp[i-1][i-1]+triangle[i][i];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < i; j++){
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j])+triangle[i][j];
            }
        }
        
        int res = dp[m-1][0];
        for(int i = 1; i < m; i++){
            res = Math.min(res, dp[m-1][i]);
        }
        return res;
    }
}


//Bottom to Top
//1629ms
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        
        if(triangle == null || triangle.length == 0) return 0;
        if(triangle[0] == null || triangle[0].length == 0) return 0;
        
        int m = triangle.length;
        int[][] dp = new int[m][m];
        
        for(int i = 0; i < m; i++){
            dp[m-1][i] = triangle[m-1][i];
        }
        
        for(int i = m-2; i>= 0; i--){
            for(int j = 0; j<= i; j++){ // be careful this is j<= i
                dp[i][j] = triangle[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
