//超超最喜欢面试别人的题目。。。注意follow up！！
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) return 0; //dont forget k = 0!!!
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int len = 0;
        int start = 0;
        for(int end = 0; end < s.length(); end++){
            char curr = s.charAt(end);
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr)+1);
                continue;
            } 
            
            map.put(curr, 1);
            while(map.size() > k){
                len = Math.max(len, end-start);
                for(int i = start; i < end; i++){
                    char c = s.charAt(i);
                    if(map.get(c) > 1) map.put(c, map.get(c)-1);
                    else {
                        map.remove(c);
                        start = i+1;
                        break;
                    }
                }
            }
        }
        len = Math.max(len, s.length()-start);
        return len;
    }
}