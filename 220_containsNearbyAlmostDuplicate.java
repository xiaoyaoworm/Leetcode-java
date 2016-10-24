//O(N) time like bucket sort solution!!!
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length <= 1) return false;
        if(k <= 0 || t< 0) return false;
        
        HashMap<Long, Long> map = new HashMap<Long, Long>();
        //negative number divide t will become close to 0, so we should remap it to another value.
        //here is using num - Integer.MIN_VALUE
        for(int i = 0; i < nums.length; i++){
            long newN = (long)nums[i] -Integer.MIN_VALUE;
            long bucket = newN / ((long)t+1); //t can be zero, so use t+1
            if(map.containsKey(bucket)) return true;//in same bucket
            if(map.containsKey(bucket-1) && Math.abs(map.get(bucket-1)-newN) <= t) return true;
            if(map.containsKey(bucket+1) && Math.abs(map.get(bucket+1)-newN) <= t) return true;
            //we should keep a window which size is k, this is from 0~nums.length-1 of nums
            if(map.size() == k){
                long removed = ((long)nums[i-k] - Integer.MIN_VALUE)/((long)t+1);
                map.remove(removed);
            }
            map.put(bucket, newN);
        }
        return false;
    }
}