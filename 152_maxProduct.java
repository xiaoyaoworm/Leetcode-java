public class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int result = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            max[i] = Math.max(Math.max(nums[i],nums[i]*max[i-1]),nums[i]*min[i-1]);
            min[i] = Math.min(Math.min(nums[i],nums[i]*max[i-1]),nums[i]*min[i-1]);
            result = Math.max(max[i],result);
        }
        return result;
    }
}