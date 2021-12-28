class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "/";
        Stack<String> stack = new Stack<String>();
        String[] words = path.split("/");
        
        for(String word: words){
            if(word.length() == 0) continue;
            else if(word.equals("..")){
                if(stack.isEmpty()){
                    continue;
                } else{
                    stack.pop();
                }
            }
            else if(word.equals(".")) continue;
            else stack.push(word);
        }
        
        if(stack.isEmpty()) return "/";
        
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.insert(0, "/" +stack.pop());//Add into the front because this is a stack! 
            // this is using insert: sb.insert(x, something)
        }
        return sb.toString();
    }
}