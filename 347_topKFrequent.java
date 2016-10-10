public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer>[] bucket = new List[nums.length+1];
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int n: nums){
    		if(map.containsKey(n)) map.put(n, map.get(n)+1);
    		else map.put(n,1);
    	}
    	for(int num: map.keySet()){
    		int val = map.get(num);
    		List<Integer> list = new ArrayList<Integer>();
    		if(bucket[val] != null) list = bucket[val];
    		list.add(num);
    		bucket[val] = list;
    	}

    	List<Integer> res = new ArrayList<Integer>();
    	for(int i = nums.length; i >=0; i--){ 
    	    //Attention: we set bucket size as nums.length+1, so here starts from nums.length
    		if(k <= 0) break;
    		if(bucket[i]!=null){
    			res.addAll(bucket[i]);
    			k-= bucket[i].size(); //Attention!!!! here is minus the bucket size!!!!
    		}
    	}
    	return res;
    }
}