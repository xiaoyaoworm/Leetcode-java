public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null) return false;
        Stack<String> stack = new Stack<String>();
        String[] arr = preorder.split(",");
        for(String str: arr){
            while(str.equals("#") && !stack.isEmpty() && stack.peek().equals("#")){
                stack.pop();
                if(stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(str); //after pop two elements(one number and one #), add one #
        }
        return stack.size() == 1 && stack.peek().equals("#"); //the last one in the stack should be #
    }
}