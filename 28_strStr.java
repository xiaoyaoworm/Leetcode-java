public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length()< needle.length()) return -1;
        for(int i = 0; i <= haystack.length()- needle.length(); i++){
            int j = 0;
            while(j< needle.length()){
                if(haystack.charAt(i+j)!= needle.charAt(j)) break;
                j++;
            }
            if(j == needle.length()) return i;
        }
        return -1;
    }
}