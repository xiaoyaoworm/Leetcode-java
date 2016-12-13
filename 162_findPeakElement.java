//O(logN)
public class Solution {
    public int findPeakElement(int[] nums) {
        return find(nums, 0, nums.length-1);
    }
    
    public int find(int[] nums, int start, int end){
        if(start == end) return start;
        if(start+1 == end){
            if(nums[start]>nums[end]) return start;
            else return end;
        } 
        
        int m = start+(end-start)/2;
        if(nums[m]> nums[m-1] && nums[m] > nums[m+1]) return m;
        if(nums[m-1]< nums[m] && nums[m]< nums[m+1] ) return find(nums, m+1, end);
        else return find(nums, start, m-1);
    }
}

//O(N)
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length<=1) return 0;
        int i = 0;
        int j = nums.length-1;
        if(nums[i]>nums[i+1]){
            return i;
        }
        if(nums[j-1]<nums[j]){
            return j;
        }
        for(int k = 1; k <= j-1; k++){
            if(nums[k]>nums[k-1] && nums[k]>nums[k+1]) return k;
        }
        return 0;
    }
}