public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
        int m = num1.length();
        int n = num2.length();
        if(m == 0) return num2;
        if(n == 0) return num1;
        int[] pos = new int[m+n];

        for(int i = m-1; i>= 0; i--){
        	for(int j = n-1; j>=0; j--){
        		int a = num1.charAt(i)-'0';
        		int b = num2.charAt(j)-'0';
        		
        		int p1 = i+j;
        		int p2 = i+j+1;
        		
        		int mul = a*b+pos[p2];
        		pos[p2] = mul%10;
        		pos[p1] += mul/10;
        	}
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < m+n; i++){
            if(sb.length() == 0 && pos[i] == 0) continue; // Ignore all initial 0, 12*0
            sb.append(pos[i]);
        }
        if(sb.length() == 0) return "0"; //12*0
        return sb.toString();
    }
}