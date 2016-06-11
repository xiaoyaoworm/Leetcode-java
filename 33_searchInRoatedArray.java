最新最简O(logn)解法：

public class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target) return mid;
            
            if(nums[mid] < nums[end]){
                if(target > nums[mid] && target <= nums[end]){
                    start = mid+1;
                } else{
                    end = mid;
                }
            } else{
                if(target > nums[mid] || target <= nums[end]){
                    start = mid+1;
                } else{
                    end = mid;
                }
            }
        }
        return -1;
    }
}

老解法：

public class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (target >= nums[0]){
            return searchHelper(nums, target,0, pivot);  
        } else{
            return searchHelper(nums, target,pivot+1, nums.length-1);
        }
    }
     
     
    public int searchHelper(int[] nums, int target, int low, int high){
        if(low > high) return -1;
        int mid = low + (high-low)/2;
        if(target == nums[mid]) return mid;
        else if(target > nums[mid]) return searchHelper(nums,target,mid+1, high);
        else return searchHelper(nums,target,low,mid-1);
    }
     
    public int findPivot(int[] nums){
        int i = 0;
        while(i < nums.length -1){
            if(nums[i] > nums[i+1]){
                return i;
            }
            i++;
        }
        return i;
    }
}