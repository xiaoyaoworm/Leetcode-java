public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        dfs(result,n,n,"");
        return result;
    }
    
    public void dfs(List<String> result, int left, int right, String s){
        if(left > right) return; //most important!!!means ) comes in front of (
        if(left == 0 && right == 0 ){
            result.add(s);
            return;
        }
        if(left > 0){
            dfs(result,left-1,right,s+"(");
        }
        if(right>0){
            dfs(result,left,right-1,s+")");
        }
    }
}