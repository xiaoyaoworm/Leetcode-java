public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper(k, n, 1, res, list);
        return res;
    }
    
    public void helper(int k, int n, int num, List<List<Integer>> res, List<Integer> list){
        if(k == 0){
            if(n == 0){
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        
        for(int i = num; i <= 9; i++){
            list.add(i);
            n-=i;
            k--;
            helper(k, n, i+1, res, list);
            list.remove(list.size()-1);
            k++;
            n+=i;
        }
    }
}
