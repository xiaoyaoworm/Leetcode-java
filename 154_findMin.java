//这种题发现如果允许duplicate，会多一个条件就是mid那个值等于左边界 或者 右边界，所以递归去掉那个相等的左/右边界 继续走一遍即可。
//平均复杂度是log(n)但是worst case是O(n)

public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        return find(nums, 0, len-1);
    }
    
    public int find(int[] nums, int i, int j){
        while(i < j){
            int m = i+(j-i)/2;
            if(nums[m] < nums[j]) j = m;
            else if(nums[m] > nums[j]) i = m+1;
            else{
                return find(nums, i, j-1); // finding nums[j] is same as nums[m], so remove this one to find others.
            }
        }
        return nums[i];
    }
}