public class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int n: nums){
            if(map.containsKey(n)) continue;
            map.put(n,1);
            
            int left = n;
            int right = n;
            if(map.containsKey(n-1)) left = n-map.get(n-1);
            if(map.containsKey(n+1)) right = n+map.get(n+1);
            
            map.put(left, right-left+1);
            map.put(right, right-left+1);
            
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}