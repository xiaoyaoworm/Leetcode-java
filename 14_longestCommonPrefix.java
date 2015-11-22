public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int length = Integer.MAX_VALUE;
        for(String str: strs){
            length = Math.min(length, str.length());
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            char prev = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                char current = strs[j].charAt(i);
                if(current!=prev) return sb.toString();
            }
            sb.append(prev);
        }
        return sb.toString();
    }
}