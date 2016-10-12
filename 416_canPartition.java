//DFS解法，不是最优解。this should be O(n!)
//check sum, if sum is odd, of course return false;
//our target become find whether in this nums, there are some value adding together is target = sum/2
//Save all integer into hashmap(combine it with checking sum),
//then go through all nodes in the hashmap, it key < target && map.get(key)>0, we can use this key, make target-key, remove one this key in map.
//do DFS, then backtracking.

public class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length <= 1) return false;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int sum = 0;
        for(int n: nums){
            sum+=n;
            if(map.containsKey(n)) map.put(n,map.get(n)+1);
            else map.put(n,1);
        }
        if(sum%2 != 0) return false;
        return dfs(sum/2, map);
    }
    
    
    public boolean dfs(int target, HashMap<Integer, Integer> map){
        if(map.containsKey(target) && map.get(target)>0) return true;
        for(int key: map.keySet()){
            if(key < target && map.get(key) > 0){ //do not forget check map.get(key)>0
                map.put(key, map.get(key)-1);
                if(dfs(target-key,map)) return true;;
                map.put(key, map.get(key)+1);
            }
        }
        return false;
    }
    
}