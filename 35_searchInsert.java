public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        return bs(nums,0,nums.length-1,target);
    }
    
    public int bs(int[] nums, int start, int end, int target){
        int mid = start+(end-start)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target){
            if(start<mid) return bs(nums,start,mid-1,target);
            else return start;
        }
        else{
            if(mid<end) return bs(nums,mid+1,end,target);
            else return end+1;
        } 
    }
}