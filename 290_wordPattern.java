public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null && str == null) return true;
        if(pattern == null || str == null) return false;
        
        String[] strs = str.split(" ");
        if(strs.length != pattern.length()) return false;
        
        HashMap<Character, String> map1 = new HashMap<Character, String>();
        HashMap<String, Character> map2 = new HashMap<String, Character>();
        
        int length = strs.length;
        for(int i = 0; i < length; i++){
            char a = pattern.charAt(i);
            String b = strs[i];
            if(map1.containsKey(a)){
                if(!map1.get(a).equals(b)) return false;
            } else{
                map1.put(a,b);
            }
            
            if(map2.containsKey(b)){
                if(map2.get(b)!=a) return false;
            } else{
                map2.put(b,a);
            }
        }
        return true;
    }
}