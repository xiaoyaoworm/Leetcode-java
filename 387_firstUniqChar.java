public class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() ==0) return -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        List<Character> list = new LinkedList<Character>();
        HashSet<Character> duplicate = new HashSet<Character>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                duplicate.add(c);
            } else{
                map.put(c, i);
                list.add(c);
            }
        }
        
        
        for(int i = 0; i < list.size(); i++){
            if(duplicate.contains(list.get(i))) continue;
            return map.get(list.get(i));
        }
        return -1;
    }
}