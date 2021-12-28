public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int num = words.length;
        int len = words[0].length();
        if(s == null || s.length() < num*len) return res;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        for(int i = 0; i <= s.length() - num*len; i++){ //Attntion: this is <= not <
            HashMap<String, Integer> copy = new HashMap<>(map);//Need a copy!!!!
            for(int k = 0; k < num; k++){
                String str = s.substring(i+k*len, i+k*len+len);
                if(copy.containsKey(str)){
                    if(copy.get(str) == 0) break;
                    else if(copy.get(str) == 1) copy.remove(str);
                    else copy.put(str, copy.get(str)-1);
                    if(copy.isEmpty()){
                        res.add(i);
                        break;//need this break!
                    }
                } else break;
            }
        }
        return res;
    }
}