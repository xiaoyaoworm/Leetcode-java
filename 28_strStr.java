public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null && needle == null) return -1;
        if(needle.length() == 0) return 0;
        if(haystack.length() == 0) return -1;
        
        int hayLeng = haystack.length();
        int needLeng = needle.length();
        int k = hayLeng-needLeng;
        for(int i = 0; i <= k; i++){
            int j = 0;
            while(j<needLeng){
                if(haystack.charAt(i+j)!=needle.charAt(j)) break;
                j++;
            }
            if(j == needLeng){
                return i;
            }
        }
        return -1;
    }
}