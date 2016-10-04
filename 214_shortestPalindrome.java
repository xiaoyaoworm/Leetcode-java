



//TLE！！！！O(n^2)
//One in the middie is 'b', the other all input chars are 'a', Tons of.

public class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s; //aacecaaa
        String sub = null;
        StringBuffer sb = new StringBuffer();
        for(int i = s.length()-1; i >=0; i--){ //i = 7-->0
            sub = s.substring(0, i+1);
            if(isPalindrome(sub)){
                for(int j = s.length()-1; j >i; j--){
                    sb.append(s.charAt(j));
                }
                sb.append(s);
                return sb.toString();
            }
        }
        return null;
    }
    
    public boolean isPalindrome(String str){
        if(str == null) return false;
        if(str.length() <= 1) return true;
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}