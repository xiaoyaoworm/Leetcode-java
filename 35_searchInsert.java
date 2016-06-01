最新解法：
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target == nums[mid]) return mid;
            else if(target > nums[mid]) start = mid+1;
            else end = mid-1;
        }
        return start;
    }
}
注意那个while里面是有等号的！！！



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



