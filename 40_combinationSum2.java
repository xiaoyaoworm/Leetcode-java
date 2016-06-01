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