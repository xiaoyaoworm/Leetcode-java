public class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<Character>();
        char[] arr = expression.toCharArray();

        //be careful: The conditional expressions group right-to-left (as usual in most languages).
        for(int i = arr.length-1; i >= 0; i--){ 
            char c= arr[i];
            if(!stack.isEmpty() && stack.peek() == '?') { //need to check empty!!!
            	stack.pop();//pop '?''
                char first = stack.pop(); 
                stack.pop();//pop ':'
                char second = stack.pop();
                if (c == 'T') stack.push(first);
                else if (c == 'F') stack.push(second);
            } else{
                stack.push(c);
            }
        }
        Character res = stack.pop();
        return res.toString();
    }
}