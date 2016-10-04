//house rob的follow up，只需要知道 如果是一个圈，那么就是从两个range的rob：0~len-2和1~len-1 取两者的较大值。
//robInRange来源于house rob的第一题。详情见198_rob.java
//需要著名的是，如果nums.length == 1需要单独拿出来，因为后面那个要找的是 0~len-2,len-2 = -1

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0]; // need to specify!!!!
        return Math.max(robInRange(nums, 0, nums.length-2), robInRange(nums, 1, nums.length-1));
    }
    
    public int robInRange(int[] nums, int start, int end) {
        int preNot = 0;
        int preYes = 0;
        for(int i = start; i <= end; i++){
            int not = preNot;
            int yes = preYes;
            preNot = Math.max(not,yes); 
            preYes = Math.max(yes, not+nums[i]);
        }
        return Math.max(preNot, preYes);
    }
}