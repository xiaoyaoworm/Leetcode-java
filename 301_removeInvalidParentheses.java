public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null) return result;
        
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        
        queue.add(s);
        set.add(s);
        
        boolean found = false; //!!!
        
        while(!queue.isEmpty()){
            String t = queue.remove();
            
            if(isValid(t)){
                result.add(t);
                found = true;
            }
            
            if(found) continue; // found in this level, so no need to add next level string in queue
            
            for(int i = 0; i < t.length(); i++){
                char c = t.charAt(i);
                if(c != '(' && c != ')') continue; // ignore non-'(' and ')'
                String cur = t.substring(0,i) + t.substring(i+1);
                if(set.contains(cur)) continue; // queue already has similar one, ignore this one.
                else{
                    queue.add(cur);
                    set.add(cur);
                }
            }
        }
        return result;
    }
    
    public boolean isValid(String s){
        int count = 0;
        for(char c: s.toCharArray()){
            if(c == '(') count++;
            if(c == ')') count --;
            if(count < 0) return false;
        }
        return count == 0;
    }
}