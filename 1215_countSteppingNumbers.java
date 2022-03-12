class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList<Integer>();
        if(low > high) return res;
        for(int i = 0; i <= 9; i++){
            dfs(low, high, res, i);
        }
        Collections.sort(res);
        return res;
    }
    
    //long as cur because it may above int
    public void dfs(int low, int high, List<Integer> res, long cur){
        if(cur >= low && cur <= high) {
            res.add((int)cur); 
        }
        // Don't forget, 01 should not happen, 
        // if cur < low, we still need it to added into larger than low to count.
        // Therefore only do cur > high return.
        if(cur == 0 || cur > high) return;

        long last = cur%10;
        long inc = cur*10+last+1;
        long dec = cur*10+last-1;
        //can only increase
        if(last == 0){
            dfs(low, high, res, inc);
        }
        //can only decrease
        else if(last == 9){
            dfs(low, high, res, dec);
        }
        //both work
        else {
            dfs(low, high, res, dec);
            dfs(low, high, res, inc);
        }
    }
}