public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        for(int i = 0; i < nums.length-1; i++){
            int j = i+1;
            if(nums[i] == 0){
                while(j < nums.length){
                    if(nums[j] == 0){
                        j++;
                    } else{
                        swap(nums,i,j);
                        break;
                    }
                }
            } else continue;
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}