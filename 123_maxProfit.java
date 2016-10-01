public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length<=1) return 0;
        // use k to make this problem general
        int k = 2;
        int[][] dp = new int[k+1][prices.length+1];
        
        //dp[i][j] means until reaching current prices[j], i times transactions make how much profit
        //All dp[0][i] = 0 due to if you do 0 transaction, of course profit is 0
        //All dp[i][0] = 0 due to if you do i transaction but you don't see any stock there, profit is 0
        int res = 0;
        for(int i = 1; i <= k; i++){
            int tmpMax = dp[i-1][0]-prices[0];
            for(int j = 1; j < prices.length; j++){
                dp[i][j] = Math.max(dp[i][j-1], prices[j]+tmpMax);
                tmpMax = Math.max(tmpMax, dp[i-1][j]-prices[j]);
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
        //Here using res not dp[k][prices.length] because k may only be 1, 
        //in such scenario [1,2], you can only do one profit, the result is in dp[0][2] not in dp[1][2]
    }
}

//本题还可以优化的，目前空间复杂度比较多，但比较好理解的解法！！！时间复杂度O(kn) 空间复杂度O(kn)