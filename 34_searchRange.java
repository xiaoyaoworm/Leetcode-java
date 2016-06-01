public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        if(nums == null || nums.length == 0) return result;
        int start = 0;
        int end = nums.length-1;
        //find left boundry
        while(start<end){
            int mid = start+(end-start)/2;
            if(target > nums[mid]) start = mid+1;
            else end = mid;
        }
        if(nums[start] == target) result[0] = start;
        
        end = nums.length-1;
        while(start<end){
            int mid = start+(end-start)/2+1;//Most important to make it a little bit right
            if(target<nums[mid]) end = mid-1;
            else start = mid;
        }
        if(nums[start] == target) result[1] = start;
        return result;
    }
}