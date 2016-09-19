public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null) return res;
        
        res.add(new ArrayList<Integer>());
        
        for(int i = 0; i < nums.length; i++){
            int size = res.size();
            for(int j = 0; j < size; j++){
                List<Integer> copy = new ArrayList<Integer>(res.get(j));
                copy.add(nums[i]);
                res.add(copy);
            }
        }
        return res;
    }
}


public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(nums, 0, res, list);
        return res;
    }
    
    public void dfs(int[] nums, int pos, List<List<Integer>> res, List<Integer> list){
        res.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            dfs(nums, i+1, res, list);
            list.remove(list.size()-1);
        }
        
    }
}
