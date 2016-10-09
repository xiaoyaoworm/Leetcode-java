public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(abbr == null || word == null) return false;
        int i = 0;
        int j = 0;
        while(i < word.length() && j < abbr.length()){
            if(word.charAt(i) == abbr.charAt(j)){
                i++;
                j++;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9')  return false; 
            // Attention, here includes 0, 0 should not be there.
            int start = j;
            while(j< abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                j++;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i+=num;
        }
        return i == word.length() && j == abbr.length();
    }
}