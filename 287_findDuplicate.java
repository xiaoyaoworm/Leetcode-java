public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        for(int i = 0; i < nums.length; i++){
            while(nums[i]!= i && nums[i]!= nums[nums[i]]){
                swap(nums, i, nums[i]); //swap index i with index nums[i], if not same!!!
            }
            if(nums[i] == nums[nums[i]]) return nums[i];
        }
        return 0;
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}