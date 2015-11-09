public class Solution {
    public int titleToNumber(String s) {
        if(s == null || "".equals(s)) return 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            result = result*26 + convert(c);
        }
        return result;
    }
    
    public int convert(char c){
        return c-'A'+1;
    }
}