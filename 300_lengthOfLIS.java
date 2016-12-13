//O(nlogn):
//Ref: https://discuss.leetcode.com/topic/28738/java-python-binary-search-o-nlogn-time-with-explanation

//tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
// For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

// len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
// len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
// len = 3   :      [4, 5, 6]            => tails[2] = 6
// We can easily prove that tails is a increasing array. Therefore it is possible to do a binary search in tails array to find the one needs update.

// Each time we only do one of the two:

// (1) if x is larger than all tails, append it, increase the size by 1
// (2) if tails[i-1] < x <= tails[i], update tails[i]

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        
        int size = 0;
        for(int n: nums){
            int i = 0;
            int j = size;
            while(i!=j){
                int m = i+(j-i)/2;
                if(tails[m] < n){
                    i = m+1;
                } else{
                    j = m;
                }
            }
            tails[i] = n;// binary search to find 
            if(i == size) size++;
        }
        return size;
    }
}



//O(n^2) Answers:

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