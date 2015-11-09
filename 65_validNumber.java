//http://blog.csdn.net/ever223/article/details/44854209


public class Solution {
    public boolean isNumber(String s) {
        boolean hasNum = false;
        boolean hasDecimal = false;
        boolean hasE = false;
        s = s.trim();
        if(s == null || "".equals(s))return false;
        int i = 0;
        if(isSign(s.charAt(0))){
            i++;
        }
        while(i<s.length()){
            char c = s.charAt(i);
            if(isDigit(c)){
                if(!hasNum){
                    hasNum= true;
                }
            }
            else if(isDecimal(c)){
                if(hasDecimal || hasE) return false;
                hasDecimal = true;
            } else if(isE(c)){
                if(hasE || !hasNum || (++i)>=s.length()){
                    return false;
                }
                if(!isSign(s.charAt(i))){
                    i--;
                }
                hasE = true;
                hasNum = false;
            } else{
                return false;
            }
            i++;
        }
        return hasNum;
    }
    
    public boolean isSign(char c){
        return c == '+' || c == '-';
    }
    
    public boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
    
    public boolean isE(char c){
        return c == 'e';
    }
    
    public boolean isDecimal(char c){
        return c == '.';
    }
}