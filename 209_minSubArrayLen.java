public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int minLen = 0;
        int pre = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            
            while(sum >= s){
                sum-=nums[pre];
                if(sum < s){
                    if(minLen == 0 || minLen > i-pre+1){
                        minLen = i-pre+1;
                    }
                }
                pre++;
            }
        }
        return minLen;
    }
}