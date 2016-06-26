public class Solution {
    public String addBinary(String a, String b) {
        if(a == null) return b;
        if(b == null) return a;
        
        StringBuffer sb = new StringBuffer();
        int m = a.length()-1;
        int n = b.length()-1;
        int carry = 0;
        while(m>=0 || n>=0 || carry == 1){
            int i = 0;
            int j = 0;
            if(m >= 0){
                i = a.charAt(m)-'0';
                m--;
            }
            if(n >= 0){
                j = b.charAt(n)-'0';
                n--;
            }
            int sum = i+j+carry;
            sb.append(sum%2);
            carry = sum/2;
        }
        return sb.reverse().toString();
    }
}