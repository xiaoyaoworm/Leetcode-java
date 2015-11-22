public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0) return s;
        if(numRows == 1) return s;
        int t = numRows*2-2;
        StringBuffer sb = new StringBuffer();
        for(int k = 0; k< numRows; k++){
            int first = k;
            int second = t-k;
            if(k == 0 || k == numRows-1){
                while(first<s.length()){
                    sb.append(s.charAt(first));
                    first+=t;
                }
            } else{
                while(first<s.length()){
                    sb.append(s.charAt(first));
                    if(second < s.length()){
                        sb.append(s.charAt((second)));
                    }
                    first+=t;
                    second+=t;
                }
            }
        }
        return sb.toString();
        
    }
}