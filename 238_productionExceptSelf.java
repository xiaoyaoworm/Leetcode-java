public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        int zero_count = 0;
        int first_zero_index = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) {
                zero_count++;
                first_zero_index = i;
            } else{
                product*=nums[i];
            }
        }
        if(zero_count == 0){
            for(int i = 0; i < nums.length; i++){
                result[i] = product/nums[i];
            }
        } else if(zero_count == 1){
            result[first_zero_index] = product;
        } 
        return result;
    }
}