public class Solution {
    public String countAndSay(int n) {
        if(n<=0) return null;
        String result = "1";
        if(n==1) return result;
        for(int i = 2; i<= n; i++){
            StringBuffer sb = new StringBuffer();
            char prev = result.charAt(0);
            int count = 1;
            for(int j = 1; j < result.length(); j++){
                char next = result.charAt(j);
                if(next == prev) count++;
                else{
                    sb.append(count);
                    sb.append(prev);
                    prev = next;
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(prev);
            result = sb.toString();
        }
        return result;
    }
}