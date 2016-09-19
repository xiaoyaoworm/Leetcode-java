public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, res, list);
        return res;
    }
    
    public void helper(int[] candidates, int target, int pos, List<List<Integer>> res, List<Integer> list){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<Integer>(list));  //如果不在下面make a copy那就在这里make a copy！！！
            return;
        }
        
        for(int i = pos; i < candidates.length; i++){
            list.add(candidates[i]);
            target-=candidates[i];
            helper(candidates, target, i, res, list);
            list.remove(list.size()-1);
            target+=candidates[i];
        }
    }
    
    
}

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        else if(target < 0){
            return;
        } else{
            for(int i = index; i < candidates.length; i++){
                List<Integer> copy = new LinkedList<Integer>(list);
                copy.add(candidates[i]);
                dfs(candidates, target-candidates[i], result, copy, i);
            }
        }
    }
}