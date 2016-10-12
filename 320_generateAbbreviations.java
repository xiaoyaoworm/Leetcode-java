public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        if(word == null) return res;
        dfs(word, 0, res, "", 0);
        return res;
    }
    
    public void dfs(String word, int pos, List<String> res, String current, int count){
        if(pos == word.length()){
            if(count > 0) current += count;
            res.add(current);
            return;
        }
        dfs(word, pos+1, res, current, count+1); //add current pos char as number, count+1
        dfs(word, pos+1, res, current+ (count == 0? "" : count) + word.charAt(pos), 0); 
        // add current pos char as char, (add count in front), reset count = 0
    }
}