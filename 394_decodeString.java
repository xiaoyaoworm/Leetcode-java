//In two parts, please add result.push("") there, one is in the begining, the second is seeing '[', this is in case of later result.pop() won't throw empty exception.

public class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() ==0) return s;
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<String> result = new Stack<String>();
        result.push("");//dont forget!we have lots of result.pop() there
        int i = 0;
        while(i < s.length()){
            if(isDigit(s.charAt(i))){
                int num = 0;
                while(i < s.length() && isDigit(s.charAt(i))){
                    num = num*10+(s.charAt(i)-'0');
                    i++;
                }
                numStack.push(num);
            } else if(s.charAt(i) == '['){
                result.push("");//same as before!!!
                i++;
            } else if(s.charAt(i) == ']'){
                String str = result.pop();
                StringBuffer sb = new StringBuffer();
                int time = numStack.pop();
                for(int k = 0; k < time; k++){
                    sb.append(str);
                }
                result.push(result.pop()+sb.toString());
                i++;
            } else{
                result.push(result.pop()+s.charAt(i));
                i++;
            }
        }
        return result.pop();
    }
    
    public boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
    
}