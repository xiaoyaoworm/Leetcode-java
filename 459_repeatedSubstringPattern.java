public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        if(str == null || str.length() <= 1) return false;
        int len = str.length();
        for(int i = len/2; i> 0; i--){
            if(len % i!= 0) continue;
            String pattern = str.substring(0, i);
            int j = i;
            while(j < len){
                if(!str.substring(j, j+i).equals(pattern)) break;
                j+=i;
            }
            if(j == len) return true;
        }
        return false;
    }
}