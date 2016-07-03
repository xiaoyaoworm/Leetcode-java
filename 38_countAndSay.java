public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i<n;i++){
            s = helper(s);
        }
        return s;
    }
    
    public String helper(String s){
        StringBuffer sb = new StringBuffer();
        
        int count = 1;
        char c = s.charAt(0);
        
        int i = 1;
        while(i< s.length()){
            if(s.charAt(i) == c){
                count++;
            }
            else{
                sb.append(count);
                sb.append(c);
                count = 1;
                c = s.charAt(i);
            }
            i++;
        }
        sb.append(count);
        sb.append(c);
        
        return sb.toString();
    }
}