public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return null;
        String result = "";
        int minLen = s.length()+1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            } else{
                map.put(c, 1);
            }
        }
        
        int start = 0;
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)>=0) {
                    count++;
                }
            }
            
            while(count == t.length()){
                char pre = s.charAt(start);
                if(map.containsKey(pre)){
                    map.put(pre,map.get(pre)+1);
                    if(map.get(pre)>0){
                        if(minLen > i+1-start){
                            minLen = i+1-start;
                            result = s.substring(start, i+1);
                        }
                        count--;
                    }
                }
                start++;
            }
        }
        return result;
    }
}