public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0;
        int size = nums.length;
        while(i <= size-1){
            if(nums[i]==val){
                nums[i] = nums[size-1];
                nums[size-1] = 0;
                size--;
            } else{
                i++;
            }
        }
        return size;
    }
}