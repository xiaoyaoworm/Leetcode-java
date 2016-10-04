//O(N) space
public class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        for(int i = 1; i <= nums.length; i++){ // !!<=
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]); 
            // dp[i][0] in step i, 0: do not take current, now profit is Max of last step no matter take it or not
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+nums[i-1]);//nums: i-1 not i
            // dp[i][1] om step i, 1: take current, now profit is Max of last step taking!! or last step not taking + take current
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);// do not forget both should be correct, get max
    }
}

//O(1) space
//看上面的解法我们发现我们其实可以只用两个值替代那个二维数组。用两个yes和no去存储暂时的值。
//dp[i][0]用preNot代替，dp[i][1]用preYes代替。
public class Solution {
    public int rob(int[] nums) {
        int preNot = 0;
        int preYes = 0;
        for(int n: nums){
            int not = preNot;
            int yes = preYes;
            preNot = Math.max(not,yes); 
            preYes = Math.max(yes, not+n);
        }
        return Math.max(preNot, preYes);
    }
}


//老的O(N) space
public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int i = 2; i<nums.length+1; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }
}