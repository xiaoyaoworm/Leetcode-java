public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0 ) return s.length() == 0;
        
        String next = (p.length()>1)?String.valueOf(p.charAt(1)):"";
        char sc = (s.length()>0)?s.charAt(0):0;
        char pc = p.charAt(0);
        
        if(!next.equals("*")){
            return ((sc == pc) || (sc != 0&& pc == '.')) && isMatch(s.substring(1),p.substring(1)); 
        } else{
            while ((sc == pc) || (sc!=0&& pc == '.')){
                if(isMatch(s,p.substring(2))) return true;
                s = s.substring(1);
                sc = (s.length()>0) ? s.charAt(0): 0;
            }
            return isMatch(s,p.substring(2));
        }
    }
}