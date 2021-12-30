class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k > n) return res;
        HashSet<Integer> used = new HashSet<Integer>();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = i+1;
        }
        dfs(nums, k, res, new ArrayList<Integer>(), used, 0);
        return res;
    }
    
    public void dfs(int[] nums, int k, List<List<Integer>> res, List<Integer> list, HashSet<Integer> used, int pos){
        if(list.size() == k){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = pos; i < nums.length; i++){
            if(used.contains(nums[i])) continue;
            list.add(nums[i]);
            used.add(nums[i]);
            dfs(nums, k, res, list, used, i+1);
            list.remove(list.size()-1);
            used.remove(nums[i]);
        }
    }
}