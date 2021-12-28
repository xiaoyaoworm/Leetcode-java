public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length()==0) return 0;
        String[] arr = s.split(" ");
        if(arr.length == 0) return 0;
        return arr[arr.length-1].length();
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int i = s.length()-1;
        int res = 0;
        while(s.charAt(i)==' '){
            i--;
        }
        while(i >= 0 && s.charAt(i)!= ' '){
            i--;
            res++;
        }
        return res;
    }
}