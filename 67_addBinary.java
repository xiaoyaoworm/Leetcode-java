public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        
        StringBuffer sb = new StringBuffer();
        int m = a.length()-1;
        int n = b.length()-1;
        int carry = 0;
        
        while(m>=0 || n >=0 || carry>0){
            int i = 0;
            int j = 0;
            if(m>=0){
                i = a.charAt(m)-'0';
            }
            if(n>=0){
                j = b.charAt(n)-'0';
            }
            sb.append((i+j+carry)%2);
            carry = (i+j+carry)/2;
            m--;
            n--;
        }
        return sb.reverse().toString();
        
    }
}