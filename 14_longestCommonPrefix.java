public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for(String str: strs){
            if(str.length() < minLen){
                minLen = str.length();
            }
        }
        
        String prev = "";
        for(int i = 0; i < minLen; i++){
            char current = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(current!=strs[j].charAt(i)){
                    return prev;
                }
            }
            prev =  strs[0].substring(0,i+1);
        }
        return prev;
    }
}