public class Solution {
    public int maxSubArray(int[] nums) {
        int sum[] = new int[nums.length]; //Same size is fine!
        sum[0] = nums[0];
        int result = nums[0]; // Attention here, result should not be 0 but nums[0] which can be negative
        for(int i = 1; i < nums.length; i++){
            sum[i] = Math.max(sum[i-1]+nums[i], nums[i]);
            result = Math.max(result,sum[i]);
        }
        return result;
    }
}


//follow up: if this is data stream we cannot save dp: we use two pointer to solve this.
public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int result = nums[0];
        int current = nums[0];
        
        for(int i = 1; i< nums.length; i++){
            current = Math.max(pre+nums[i], nums[i]);
            result = Math.max(current,result);
            pre = current;
        }
        return result;
    }
}