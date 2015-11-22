public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length()%2 == 1) return false;
        if(s.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        
        for(char c: s.toCharArray()){
            if(c == '(') stack.push(')');
            else if(c == '[') stack.push(']');
            else if(c == '{') stack.push('}');
            else{
                if(stack.isEmpty()) return false;
                char temp = stack.pop();
                if(temp!=c) return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}