public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = 0;
        int i = 0;
        int result = 0;
        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            if(sum >= s) {
                if (result == 0){
                    result = j+1-i;
                } else result = Math.min(result, j+1-i);
            }
            
            while(sum > s && i< nums.length){
                sum-=nums[i];
                i++;
                if(sum >= s) result = Math.min(result, j+1-i);
            }
        }
        return result;
    }
}