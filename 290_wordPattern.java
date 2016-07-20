public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null) return str == null;
        if(pattern.length() == 0) return str.length() == 0;
        
        String[] strArr = str.split(" ");
        if(strArr.length!=pattern.length()) return false;
        char[] patternArr = pattern.toCharArray();
        
        HashMap<Character, String> ps = new HashMap<Character, String>();
        HashMap<String, Character> sp = new HashMap<String, Character>();
        
        for(int i = 0; i < patternArr.length; i++){
            char c = patternArr[i];
            String s = strArr[i];
            if(ps.containsKey(c)){
                if(!ps.get(c).equals(s)) return false;
            } else{
                ps.put(c,s);
            }
            
            if(sp.containsKey(s)){
                if(sp.get(s)!=c) return false; 
            } else{
                sp.put(s,c);
            }
        }
        return true;
    }
}