public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        s = s.trim().toUpperCase();
        if(s.length()==0) return true;
        int left = 0;
        int right = s.length()-1;
        
        while(left<right){
            while(left <= s.length()-1 && !isNumberLetter(s.charAt(left))){
                left++;
            }
            while(right >= 0 && !isNumberLetter(s.charAt(right))){
                right--;
            }
            if(left > right) break;
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    
    public boolean isNumberLetter(char c){
        return (c >= 'A' && c<='Z') ||(c>='0'&& c<='9');
    }
}