public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) return true;
        if(Math.abs(s.length()-t.length()) > 1) return false;
        if(s.length() == t.length()) return isModify(s,t);
        if(s.length() > t.length()) return isDelete(s,t);
        else return isDelete(t,s);
    }
    
    public boolean isModify(s,t){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)) count++;
        }
        return count == 1;
    }
    
    public boolean isDelete(s,t){
        for(int i = 0; i < t.length(); i++){
            if(s.charAt(i)!=t.charAt(i){
                return s.substring(i+1).equals(s.substring(i));
            }
        }
        return true;
    }
}