public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int len = s.length();
        int res = 0;
        
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(i);
            else if(c == ')'){
                if(stack.isEmpty()){
                    stack.push(i);
                } else{
                    if(s.charAt(stack.peek()) == '(') stack.pop();
                    else stack.push(i);
                }
            }
        }
        
        if(stack.isEmpty()) return len;
        int prev = s.length();
        while(!stack.isEmpty()){
            int curr = stack.pop();
            res = Math.max(prev-curr-1, res);
            prev = curr;
        }
        res = Math.max(prev, res);
        return res;
    }
}