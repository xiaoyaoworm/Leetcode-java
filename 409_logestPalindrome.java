public class Solution {
    public int longestPalindrome(String s) {
        if(s == null) return 0;
        if(s.length() <= 1) return s.length();
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        boolean hasOdd = false;
        for(char c: s.toCharArray()){
            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        
        int res = 0;
        for(Character c: map.keySet()){
            res += map.get(c)/2 * 2;
            if(map.get(c)%2 == 1) hasOdd = true;
        }
        if(hasOdd) res++;
        return res;
    }
}