public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length<=1) return 0;
        int i = 0;
        int j = nums.length-1;
        if(nums[i]>nums[i+1]){
            return i;
        }
        if(nums[j-1]<nums[j]){
            return j;
        }
        for(int k = 1; k <= j-1; k++){
            if(nums[k]>nums[k-1] && nums[k]>nums[k+1]) return k;
        }
        return 0;
    }
}