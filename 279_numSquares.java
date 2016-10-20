//想较楼下的LTE解法优化了一步，我们只把下面解法的j跳着走即可，我们只需要考虑j是平方和的情况。dp[j] = 1, dp[i] = Math.max(dp[i], dp[i-j*j]+1)
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 1; i*i <= n; i++){
            dp[i*i] = 1;//Attention, here is dp[i*i];
        }
        
        for(int i = 1; i <= n; i++){
            if(dp[i]!= 1){
                int j = 1;
                while(j*j <= i){
                    dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                    j++;
                }
            }
        }
        return dp[n];
    }
}


//TLE解法，简单的DP解法。标记所有的平方数为1，非平方数检查所有前面任意两个index和为当前index的和，最小即为结果。
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 1; i*i <= n; i++){
            dp[i*i] = 1;//Attention, here is dp[i*i];
        }
        
        for(int i = 1; i <= n; i++){
            if(dp[i] != 1){
                for(int j = 1; j < i; j++){
                    dp[i] = Math.min(dp[i], dp[i-j]+dp[j]);
                }
            }
        }
        return dp[n];
    }
}