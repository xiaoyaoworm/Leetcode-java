public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null) return res;
        
        Arrays.sort(nums);
        int start = 0;
        res.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] != nums[i-1]) start = 0;
            int size = res.size();
            for(int j = start; j < size; j++){
                List<Integer> copy = new ArrayList<Integer>(res.get(j));
                copy.add(nums[i]);
                res.add(copy);
            }
            start = size;
        }
        return res;
    }
}

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, 0, res, list);
        return res;
    }
    
    public void dfs(int[] nums, int pos, List<List<Integer>> res, List<Integer> list){
        res.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < nums.length; i++){
            if(i!=pos && nums[i-1] == nums[i]) continue;
            list.add(nums[i]);
            dfs(nums, i+1, res, list);
            list.remove(list.size()-1);
        }
    }
}
