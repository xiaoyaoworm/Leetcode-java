//Search in roated array的follow up题目，允许重复数字。
//时间复杂度还是logN但是worst case是O(n) 譬如1111113 rotate--> 1311111 找3 或者找2.我们发现mid = l = r，不晓得去左边还是去右边。这种情况下我们只好l++,再重复一遍这个过程。
//如果发现mid并不等于 头或尾，那么跟原始的那道题是一样的。

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            int m = i+(j-i)/2;
            if(nums[m] == target) return true;
            if(nums[m] > nums[i]){
                if(target>= nums[i] && target < nums[m]) j = m-1;
                else i = m+1;
            } else if(nums[m] < nums[i]){
                if(target>= nums[i] || target < nums[m]) j = m-1;
                else i = m+1;
            } else{
                i++;
            }
        }
        return false;
    }
}