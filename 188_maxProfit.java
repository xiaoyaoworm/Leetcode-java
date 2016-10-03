//这道题基本上跟123.Best Time to Buy and Sell Stock III一模一样。
//唯一需要注意的一个条件就是我们发现如果k过半的话，那么我们足够收集到所有的profit。所以累加即可。
//剩下的dp问题就跟123完全一样了。详情请看那个文件： 123_maxProfit.java

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        if(k > len/2) return quickSolve(prices);//Very important!!!! if k > len/2, we can collect all profits.
        
        int[][] dp = new int[k+1][prices.length];
        int res = 0;
        for(int i = 1; i <= k; i++){
            int tmpMax = dp[i-1][0]-prices[0];
            for(int j = 1; j < prices.length; j++){
                dp[i][j] = Math.max(dp[i][j-1], prices[j]+tmpMax);
                tmpMax = Math.max(tmpMax, dp[i-1][j]-prices[j]);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
    
    public int quickSolve(int[] prices){
        int profit = 0;
        int i = 1;
        while(i < prices.length){
            if(prices[i] > prices[i-1]) profit+=(prices[i]-prices[i-1]);
            i++;
        }
        return profit;
    }
}