public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null) return 0;
        if(s.length() <= 1) return s.length();
        int len = s.length();
        
        HashMap<Character, Set<Integer>> map = new HashMap<Character, Set<Integer>>();
        
        int res = 0;
        int pre = 0;
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            Set<Integer> set = new HashSet<Integer>();
            if(map.containsKey(c)){
                set = map.get(c);
            }
            set.add(i);
            map.put(c, set);
            
            while(map.size() > 2){ 
                if(res == 0 || res < i-pre) res = i-pre;
                for(int k = pre; k < i; k++){
                    char ch = s.charAt(k);
                    if(map.get(ch).size() == 1){
                        map.remove(ch);
                        pre = k+1; // Pay attention, if removing k making map.size() == 2, ,we should make pre = k+1.
                        break;
                    } else{
                        map.get(ch).remove(k); // here is removing k!!! set saves index!!!
                    }
                }
            }
        }
        if(res < len-pre) res = len-pre; // do not forget!!!
        return res;
    }
}