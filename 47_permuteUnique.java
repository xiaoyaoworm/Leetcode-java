public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(nums, 0, res);
        return res;
    }
    
    public void helper(int[] nums, int pos, List<List<Integer>> res){
        if(pos == nums.length){
            List<Integer> list = new ArrayList<Integer>();
            for(int n: nums) list.add(n);
            res.add(list);
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = pos; i < nums.length; i++){
            if(i!=pos && (nums[i] == nums[i-1] || set.contains(nums[i]))) continue;
            set.add(nums[i]);
            swap(nums, pos, i);
            helper(nums, pos+1, res);
            swap(nums, pos, i);
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


//统一DFS写法
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
        }
        for(int i = 0; i < nums.length; i++){
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue; //See notes below!!!
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, res, list, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}

//The difficulty is to handle the duplicates.
//With inputs as [1a, 1b, 2a],
//If we don't handle the duplicates, the results would be: [1a, 1b, 2a], [1b, 1a, 2a]...,
//so we must make sure 1a goes before 1b to avoid duplicates
// using nums[i-1]==nums[i] && !used[i-1], we can make sure that 1b cannot be choosed before 1a