class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        
        int num = 0;
        int res = 0;
        int sign = 1;
        for(char c: s.toCharArray()){
            if(c == ' ') continue;
            if(isDigit(c)){
                num = num*10 + (c-'0');
            } else if(c == '+'){
                res += sign*num;
                num = 0;
                sign = 1;
            } else if(c == '-'){
                res += sign*num;
                num = 0;
                sign = -1;
            } else if(c == '('){
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if(c == ')'){
                res += num * sign;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        if(num!=0) res += num*sign;
        return res;
    }
    
    private boolean isDigit(char c){
        return c>= '0' && c <= '9';
    }
    
    
}