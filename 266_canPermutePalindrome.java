public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int odd = 0; 
        
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
                if(map.get(c)%2 == 0) odd--;
                else odd++;
            } else{
                map.put(c,1);
                odd++;
            }
        }
        return odd<=1;
    }
}