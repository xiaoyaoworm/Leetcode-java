public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, res, list);
        return res;
    }
    
    public void helper(int[] candidates, int target, int pos, List<List<Integer>> res, List<Integer> list){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<Integer>(list)); //注意！
            return;
        }
        
        for(int i = pos; i < candidates.length; i++){
            if(i!=pos && candidates[i] == candidates[i-1]) continue; //注意！
            list.add(candidates[i]);
            target-=candidates[i];
            helper(candidates, target, i+1, res, list);
            list.remove(list.size()-1);
            target+=candidates[i];
        }
    }
}

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, result, list, 0);
        return result;
    }
    
    public void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int index){
        if(target == 0){
            result.add(list);
            return;
        }
        if(target < 0 || index >= candidates.length){
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(i>index && candidates[i] == candidates[i-1]) continue;
            List<Integer> copy = new LinkedList<Integer>(list);
            copy.add(candidates[i]);
            dfs(candidates, target-candidates[i], result, copy, i+1);
        }
    }
    
}