public class Solution {
    public boolean isMatch(String s, String p) {
        if(p == null) return s == null;
        if(p.length() == 0) return s.length() == 0;
        
        if(p.length() == 1){
            if(p.equals("*")) return false;
            if(p.equals(".")) return s.length() == 1;
            return p.equals(s);
        }
        
        //p.length()>=2
        if(p.charAt(1) != '*'){
            if(s.length() == 0) return false;
            if(p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) return isMatch(s.substring(1), p.substring(1));
            return false;
        } else{
            if(isMatch(s,p.substring(2))) return true;
            int i = 0;
            while(i< s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
                if(isMatch(s.substring(i+1), p.substring(2))) return true;
                i++;
            }
        }
        return false;
    }
}