public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        
        int i = 0;
        boolean isPositive = true;
        if(str.charAt(i) == '-') {
            isPositive = false;
            i++;
        } else if(str.charAt(i) == '+'){
            i++;
        }
        
        double result = 0;
        while(i < str.length()){
            if(!isDigit(str.charAt(i))) break;
            int curr = str.charAt(i)-'0';
            result = result*10 + curr;
            i++;
        }
        if(!isPositive) result = -result;
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)result;
    }
    
    public boolean isDigit(char c)
    {
        return c>='0' && c<='9';
    }
}