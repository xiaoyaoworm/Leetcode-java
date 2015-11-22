public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = findPivot(nums);
        return nums[p];
    }
    
    public int findPivot(int[] nums){
        if(nums.length<=1) return 0;
        int i = 1;
        while(i<nums.length){
            if(nums[i-1]>nums[i]){
                return i;
            }
            i++;
        }
        return 0;
    }
}