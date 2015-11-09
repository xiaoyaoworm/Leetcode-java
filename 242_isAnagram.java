public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length()!=t.length()) return false;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            } else{
                map.put(c,1);
            }
        }
        for(char m: t.toCharArray()){
            if(map.containsKey(m)){
                if(map.get(m) == 0){
                    return false;
                } else{
                    map.put(m,map.get(m)-1);
                }
            } else{
                return false;
            }
        }
        return true;
    }
}