public class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else map.put(c, 1);
        }
        
        List<Character> [] bucket = new List[s.length()];
        for(char c: map.keySet()){
            int freq = map.get(c);
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(c);
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i = s.length()-1; i >= 0; i--){
            if(bucket[i]!= null){
                for(char c: bucket[i]){
                    int num = 0;
                    while(num < i){
                        sb.append(c);
                        num++;
                    }
                }
            }
        }
        return sb.toString();
    }
}