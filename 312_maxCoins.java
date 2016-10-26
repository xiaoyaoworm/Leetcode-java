public class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] newNums = new int[nums.length+2];
        newNums[0] = 1;
        newNums[nums.length+1] = 1;
        for(int i = 1; i < nums.length+1; i++){
            newNums[i] = nums[i-1];
        }
        
        int[][] memo = new int[nums.length+2][nums.length+2];
        return getMax(memo, newNums, 0, nums.length+1); //please pass the newNum rather than num.
    }
    
    //both left and right are exclusive!!!
    public int getMax(int[][] memo, int[] nums, int left, int right){
        if(left+1 == right) return 0; //dont forget, nothing inside
        if(memo[left][right] > 0) return memo[left][right]; //memorization!!!!
        int res = 0;
        for(int i = left+1; i < right; ++i){
            //nums[i] is the one which is burst this time, getMax part is which is bursted part
            res = Math.max(res, nums[left]*nums[i]*nums[right] + getMax(memo, nums, left, i) + getMax(memo, nums, i, right));
        }
        memo[left][right] = res;//memorization!!!!
        return res;
    }
}