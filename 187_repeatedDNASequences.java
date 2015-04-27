//http://xiaoyaoworm.com/blog/2015/04/17/%E6%96%B0leetcode-hashtable-5-substring-with-concatenation-of-all-words/

public class Solution {
    public List<Integer> findSubstring(String S, List<String> L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(S == null || L == null || S.length() == 0 || L.size() == 0){
            return result;
        }
        int wordLen = L.get(0).length();
        int totalLen = wordLen * L.size();
        if(totalLen > S.length()){
            return result;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String l: L){
            if(map.containsKey(l)){
                map.put(l,map.get(l)+1);
            } else{
                map.put(l,1);
            }
        }
        for(int i = 0; i <= S.length()-totalLen; i++){
            if(isValid(map,S,i,totalLen,wordLen)){
                result.add(i);
            }
        }
        return result;
    }
     
    public boolean isValid(HashMap<String, Integer> map, String S, int i, int totalLen, int wordLen){
        HashMap<String, Integer> tmpMap = new HashMap<String, Integer>(map);
        int start = i;
        int end = i+wordLen;
         
        while(end-i<=totalLen){
            String sub = S.substring(start,end);
            if(tmpMap.containsKey(sub)){
                if(tmpMap.get(sub)==0){
                    return false;
                } else{
                    tmpMap.put(sub,tmpMap.get(sub)-1);
                    start = end;
                    end = start+wordLen;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
}