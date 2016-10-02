public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            int m = i+(j-i)/2;
            if(nums[m]<nums[j]){
                j = m;
            } else{
                i = m+1;
            }
        }
        return nums[i];
    }
}
