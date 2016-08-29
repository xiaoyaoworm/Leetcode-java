public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        helper(s, 0, res, "", 0);
        return res;
    }
    
    public void helper(String s, int pos, List<String> res, String str, int count){
        if(count > 4) return;
        if(count == 4){
            if(pos == s.length()) res.add(str);
            return;
        }
        
        for(int i = pos; i < pos+3; i++){
            if(i >= s.length()) break;
            if(isValid(s, pos, i)){
                String temp = str;
                if(str.length()!=0) str = str+"."+s.substring(pos,i+1);
                else str += s.substring(pos, i+1);
                helper(s, i+1, res, str, count+1);
                str = temp;
            }
        }
    }
    
    public boolean isValid(String str, int i, int j){
        if(j > i && str.charAt(i)=='0') return false;
        int n = Integer.valueOf(str.substring(i, j+1));
        return n >=0 && n <= 255;
    }
}