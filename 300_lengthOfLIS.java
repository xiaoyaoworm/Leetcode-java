O(n^2) Answers:

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null) return 0;
        if(nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        
        for(int k = 0; k < nums.length; k++){
            dp[k] = 1;
        }
        
        int i = 0;
        int j = 1;
        while(j < nums.length){
            while(i < j){
                if(nums[i] < nums[j]){
                    dp[j] = Math.max(dp[j],dp[i]+1); 
                }
                i++;
            }
            i=0;
            j++;
        }
        
        int result = Integer.MIN_VALUE;
        for(int n: dp){
            result = Math.max(result,n);
        }
        return result;
    }
}