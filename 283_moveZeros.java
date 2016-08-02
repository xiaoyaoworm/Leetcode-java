//Follow previous non-zero sequence.

public class Solution {
    public void moveZeroes(int[] nums) {
        int fixed = 0;
        int i = 0;
        while(i< nums.length){
            if(nums[i]!= 0) {
                nums[fixed] = nums[i];
                fixed++;
            }
            i++;
        }
        while(fixed< nums.length){
            nums[fixed] = 0;
            fixed++;
        }
    }
}
