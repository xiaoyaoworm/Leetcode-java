// 贪心算法
// See the explanation here: http://www.allenlipeng47.com/blog/index.php/2016/09/12/jump-game-ii/

public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        
        int currLong = 0;
        int nextLong = 0;
        int step = 0;
        
        for(int i = 0; i < n; i++){
            if(i == currLong+1){
                step++;
                currLong = nextLong;
            }
            nextLong = Math.max(nextLong, nums[i]+i);
        }
        return step;
    }
}


// 基本跟55_canJump的jump game1一样。
// 这种方法跟word break那道题基本思路一样。这是动态规划解法。
// TLE: 超时了 因为O(n^2).
// 测试用例：25000, 24999, 24998...3,2,1,1,0,0
public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j]!= -1 && j+nums[j]>=i){
                    if(dp[i] == -1) dp[i] = dp[j] + 1;
                    else dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        if(dp[n-1] == -1) return 0;
        else return dp[n-1];
    }
}