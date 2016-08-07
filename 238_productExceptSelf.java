public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int zeroNumber = 0;
        int zeroIndex = 0;
        
        int pro = 1;
        for(int i = 0; i < nums.length; i++){
            if(zeroNumber > 1) return result;
            if(nums[i] == 0) {
                zeroNumber++;
                zeroIndex = i;
            }
            else pro*= nums[i];
        }
        
        if(zeroNumber == 0){
            for(int i = 0; i < nums.length; i++){
                result[i] = pro/nums[i];
            }
        }
        if(zeroNumber == 1){
            result[zeroIndex] = pro;
        }
        return result;
    }
}