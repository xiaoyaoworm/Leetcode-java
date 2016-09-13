一种我们只需要找最远能达到的index即可。不要那个dp数组，我们就需要记录一个值。所以一点一点扫过去，最终只要看最大是否大过最大的index。

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        
        int farthest = nums[0];
        for(int i = 1; i < n; i++){
            if(i <= farthest && nums[i]+i> farthest){
                farthest = nums[i]+i;
            }
        }
        return farthest >= n-1;
    }
}



这种方法跟word break那道题基本思路一样。
TLE: 超时了 因为O(n^2).
测试用例：25000, 24999, 24998...3,2,1,1,0,0

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        boolean[] dp = new boolean[n];
        
        dp[0] = true;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && j+nums[j]>= i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}