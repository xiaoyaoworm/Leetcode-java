public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(k,n,1,result,list);
        return result;
    }
    
    public void dfs(int k, int sum, int start, List<List<Integer>> result, List<Integer> list){
        if(list.size()==k && sum == 0){
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(list);
            result.add(temp);
        }
        
        for(int i = start; i <= 9; i++){
            if(list.size()>k) break;
            if(sum-i<0) break;
            list.add(i);
            dfs(k,sum-i,i+1,result,list);
            list.remove(list.size()-1);
        }
    }
}