public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length()!=t.length()) return false;
        HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        
        int n = s.length();
        for(int i = 0; i < n; i++){
            char p = s.charAt(i);
            char q = t.charAt(i);
            if(map1.containsKey(p)){
                if(map1.get(p)!=q) return false;
            } else{
                map1.put(p,q);
            }
            if(map2.containsKey(q)){
                if(map2.get(q)!=p) return false;
            } else{
                map2.put(q,p);
            }
        }
        return true;
    }
}