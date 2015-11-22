public class Solution {
    public String convertToTitle(int n) {
        if(n<=0) return null;
        StringBuffer sb = new StringBuffer();
        while(n!=0){
            n--; // be careful, there is no 0!!!!!!!
            char c = (char)(n%26+'A');
            n = n/26;
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}