public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i< nums.length;i++){
            if(map.containsKey(nums[i])){
                int n = map.get(nums[i]);
                if(i-n<=k) return true;
            } 
            map.put(nums[i],i);
        }
        return false;
    }
}