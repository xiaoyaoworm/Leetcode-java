public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(s, wordDict, map);
    }
    
    public List<String> dfs(String s, Set<String> wordDict, HashMap<String, List<String>> map){
        if(map.containsKey(s)) {
            return map.get(s);
        }
        
        List<String> res = new ArrayList<String>();
        if(s.length() == 0){
            res.add("");
            return res;
        }
        
        for(String word: wordDict){
            if(s.startsWith(word)){
                List<String> remainList = dfs(s.substring(word.length()), wordDict, map);
                for(String remain: remainList){
                    StringBuffer sb = new StringBuffer();
                    sb.append(word);
                    if(remain.length() != 0) sb.append(" ");
                    sb.append(remain);
                    res.add(sb.toString());
                }
            }
            
        }
        map.put(s, res);
        return res;
    }
}