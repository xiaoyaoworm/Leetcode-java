public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n<=3) return result;
        dfs(n,2,result,new ArrayList<Integer>());
        return result;
    }
    
    public void dfs(int n, int start, List<List<Integer>> result, List<Integer> list){
        if(n == 1){
            if(list.size()>1){// If size() == 1 means [n], ignore this scenario.
                result.add(list);
                return;
            }
        }
        for(int i = start; i <= n; i++){
            if(n%i == 0){
                List<Integer> copy = new ArrayList<Integer>(list);
                copy.add(i);
                dfs(n/i,i,result,copy);
            }
        }
    }
}