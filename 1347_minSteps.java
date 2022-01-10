class Solution {
    public int minSteps(String s, String t) {
        if(s == null || t == null) return 0;
        if(s.length()!= t.length()) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c: t.toCharArray()){
            if(!map.containsKey(c)) continue;
            if(map.get(c) > 1){
                map.put(c, map.get(c)-1);
            }
            else if(map.get(c) == 1){
                map.remove(c);
            } 
        }
        
        int res = 0;
        for(char c: map.keySet()){
            res += map.get(c);
        }
        return res;
    }
}