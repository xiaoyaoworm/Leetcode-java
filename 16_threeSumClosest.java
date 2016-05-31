public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null) return 0;
        int result = 0;
        if(nums.length<=3){
            for(int num: nums){
                result+=num;
            }
            return result;
        }
        Arrays.sort(nums);
        result = nums[0]+nums[1]+nums[2];
        
        for(int i = 0; i < nums.length-2; i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == target) return target;
                if(Math.abs(sum-target)<Math.abs(result-target)){
                    result= sum;
                }
                if(sum > target) k--;
                else j++;
            }
        }
        return result;
    }
}