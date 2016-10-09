public class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0) return num2;
        if(num2 == null || num2.length() == 0) return num1;
        
        int m = num1.length()-1;
        int n = num2.length()-1;
        int carry = 0;
        
        StringBuffer sb = new StringBuffer();
        
        while(m>=0 || n>= 0 ||carry == 1){
            int a = 0;
            int b = 0;
            if(m>=0){
                a = num1.charAt(m)-'0';
                m--;
            }
            if(n>=0){
                b = num2.charAt(n)-'0';
                n--;
            }
            int sum = a+b+carry;
            sb.append(sum%10);
            carry = sum/10;
        }
        return sb.reverse().toString();
    }
}