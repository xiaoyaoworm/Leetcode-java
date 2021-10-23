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

//更好理解
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findBound(nums, target, true);
        if(left == -1) return new int[]{-1,-1};
        int right = findBound(nums, target, false);
        return new int[]{left, right};
    }
    
    private int findBound(int[] nums, int target, boolean isLeft){
        int i = 0;
        int j = nums.length-1;
        
        while(i <= j){
            int mid = i+(j-i)/2;
            if(nums[mid] == target){
                if(isLeft){
                    //Find the left boundry;
                    if(mid == i || nums[mid-1]!=nums[mid]){
                        return mid;
                    } else{
                        j = mid-1;
                    }
                } else{
                    // Find the right boundry;
                    if(mid == j || nums[mid+1]!=nums[mid]){
                        return mid;
                    } else{
                        i = mid+1;
                    }
                }
            } else if(nums[mid] > target){
                j = mid-1;
            } else{
                i = mid+1;
            }
        }
        return -1;
    }
}