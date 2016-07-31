public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        if(num == null || num.length() == 0) return result;
        dfs(num, target, result, "",0,0,0);
        return result;
    }
    
    public void dfs(String num, int target, List<String> result, String path, int start, long value, long multed){
        if(start == num.length()){
            if(target == value){ // do not make it && with previous if condition, it won't return
                result.add(path);
            }
            return;
        }
        
        for(int i = start; i < num.length(); i++){
            if(i!=start && num.charAt(start) == '0') break; // jump over number looks like "0XXX", next step is sbustring this! so be careful, '0' is on start not i.
            long cur = Long.parseLong(num.substring(start, i+1));
            if(start == 0) dfs(num, target, result, path+cur, i+1, cur, cur); 
            // The first number can be combined without operation.
            else{
                dfs(num, target, result, path+"+"+cur, i+1, value+cur, cur);
                dfs(num, target, result, path+"-"+cur, i+1, value-cur, -cur); 
                //multed is -cur, not positive, be careful
                dfs(num, target, result, path+"*"+cur, i+1, value-multed+multed*cur, multed*cur);
                // be careful, multed is the one you should be careful because it may comes before *
                // so value should be value-multed+multed*cur, pass the multed*cur as multed.
            }
        }
    }
}