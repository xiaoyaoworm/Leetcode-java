public class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char tc: t.toCharArray()){
            if(map.containsKey(tc)) map.put(tc, map.get(tc)+1);
            else map.put(tc,1);
        }
        
        for(char sc: s.toCharArray()){
            if(map.get(sc) == 1) map.remove(sc);
            else map.put(sc, map.get(sc)-1);
        }
        
        return map.keySet().iterator().next();
    }
}

//Same as single number solution, initial 0, use ^ for all characters.
// x ^ 0 = x
// x ^ x = 0
public class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for(char c: s.toCharArray()){
            res^=c;
        }
        for(char c: t.toCharArray()){
            res^=c;
        }
        return res;
    }
}

