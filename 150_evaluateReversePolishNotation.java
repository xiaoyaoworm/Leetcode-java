public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for(String token: tokens){
            if("+-*/".contains(token)){
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());
                int result = 0;
                if(token.equals("+")){
                    result = a+b;
                } else if(token.equals("-")){
                    result = a-b;
                } else if(token.equals("*")){
                    result = a*b;
                } else if(token.equals("/")){
                    result = a/b;
                }
                stack.push(String.valueOf(result));
            } else{
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}