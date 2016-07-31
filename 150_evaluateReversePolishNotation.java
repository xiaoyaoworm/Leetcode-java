public class Solution {
    public int evalRPN(String[] tokens) {
        String symbols = "+-*/";
        Stack<Integer> stack = new Stack<Integer>();
        for(String s: tokens){
            if(symbols.contains(s)){
                if(stack.isEmpty()) return -1;
                int second = stack.pop();
                if(stack.isEmpty()) return -1;
                int first = stack.pop();
                
                if(s.equals("+")) stack.push(first+second);
                else if(s.equals("-")) stack.push(first-second);
                else if(s.equals("*")) stack.push(first*second);
                else if(s.equals("/")) stack.push(first/second);
            } else{
                stack.push(Integer.valueOf(s));
            }
        }
        int result = stack.pop();
        if(stack.isEmpty()) return result;
        else return -1;
    }
}