public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length()!=t.length()) return false;
        
        HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        
        int length = s.length();
        for(int i = 0; i < length; i++){
            char m = s.charAt(i);
            char n = t.charAt(i);
            if(map1.containsKey(m)){
                if(map1.get(m)!=n) return false;
            }
            if(map2.containsKey(n)){
                if(map2.get(n)!=m) return false;
            }
            map1.put(m,n);
            map2.put(n,m);
        }
        return true;
    }
}