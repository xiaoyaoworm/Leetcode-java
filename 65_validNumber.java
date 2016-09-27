//http://blog.csdn.net/ever223/article/details/44854209


public class Solution {
    public boolean isNumber(String s) {
        if(s == null) return false;
        s = s.trim();
        if(s.length() == 0) return false;
        
        boolean hasNum = false;
        boolean hasE = false;
        boolean hasDecimal = false;
        
        int i = 0;
        if(isSign(s.charAt(0))) i++;
        
        while(i<s.length()){
            char c = s.charAt(i);
            if(isNum(c)){
                if(!hasNum) hasNum = true;
            }
            else if(isDecimal(c)){
                if(hasE || hasDecimal) return false;
                hasDecimal = true;
            }else if(isE(c)){
                if(!hasNum || hasE ||(++i) >= s.length()) return false;
                if(!isSign(s.charAt(i))) i--; //attention, here is not c due to (++i) in last step
                hasE = true;
                hasNum = false;
            } else{
                return false;
            }
            i++;
        }
        return hasNum;
    }
    
    public boolean isNum(char c){
        return c >= '0' && c <= '9';
    }
    
    public boolean isDecimal(char c){
        return c == '.';
    }
    
    public boolean isE(char c){
        return c == 'e';
    }
    
    public boolean isSign(char c){
        return c == '+' || c == '-';
    }
}