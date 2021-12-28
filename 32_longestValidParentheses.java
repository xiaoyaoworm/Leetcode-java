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



//REF: https://leetcode.com/problems/longest-valid-parentheses/discuss/14126/My-O(n)-solution-using-a-stack
class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length()==0) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();//stack only store those are not in the pair indexes
        stack.push(-1);

        for(int i = 0; i <s.length(); i++){
            if(s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                } else{
                    res = Math.max(res, i-stack.peek());                    
                }
            }
        }
        return res;
    }
}