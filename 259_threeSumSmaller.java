//简易版的3sum问题，不用判断重复！！
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length <= 2) return 0;
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int j = i+1;
            int k = nums.length-1;
            int newTarget = target-nums[i];
            while(j < k){
                if(nums[j]+nums[k] < newTarget){
                    res+=k-j;
                    j++;//dont forget!!!!
                }else{
                    k--;
                }
            }
        }
        return res;
    }
}