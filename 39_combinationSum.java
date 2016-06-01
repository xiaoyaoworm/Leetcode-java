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