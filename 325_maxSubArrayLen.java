public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            if(sum == k) result = i+1;
            else if(map.containsKey(sum-k)) result = Math.max(result, i-map.get(sum-k));
            
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return result;
    }
}