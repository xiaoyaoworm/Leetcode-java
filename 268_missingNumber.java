public class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length; //This is the first data out of the 0~n-1
        for(int i = 0; i < nums.length; i++){
            result = result+i-nums[i];
        }
        return result;
    }
    
}


public class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length; //This is the first data out of the 0~n-1
        for(int i = 0; i < nums.length; i++){
            result = result^i;
            result = result^nums[i];
        }
        return result;
    }
    
}