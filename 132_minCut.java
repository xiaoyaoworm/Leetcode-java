//O(n) space!!
//O(n^2) time!!!

public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() <= 1) return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        for(int i = 0; i <= len; i++){
            dp[i] = i-1; // initial to current char numbers -1 as the most cut
        }
        
        for(int i = 0; i < len; i++){
            for(int j = 0; i-j>=0 && i+j<len && s.charAt(i-j) == s.charAt(i+j); j++){ //Even check
                dp[i+j+1] = Math.min(dp[i+j+1], 1+dp[i-j]);
            }
            for(int j = 1; i-j+1>=0 && i+j<len && s.charAt(i-j+1) == s.charAt(i+j); j++){ //Odd check
                dp[i+j+1] = Math.min(dp[i+j+1], 1+dp[i-j+1]);
            }
        }
        return dp[len];
    }
}


//代码本身没啥问题，但是碰到了TLE。。。。
//这个输入没法handle：无数个a的情况。
//aaaaa.....aaaa

public class Solution {
    public int minCut(String s) {
        if(s == null || s.length()<= 1) return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int j = 1; j <= len;j++){
            for(int i = 0; i < j; i++){
                String str = s.substring(i,j);
                if(dp[i]!=-1 && isPalidrome(str)){
                    if(dp[j] == -1) dp[j] = dp[i]+1;
                    else dp[j] = Math.min(dp[i]+1, dp[j]);
                }
            }
        }
        return dp[len]-1; //Attention, this is cut number, not how many palidromes we can cut.
    }
    
    public boolean isPalidrome(String s){
        if(s == null) return false;
        if(s.length()<= 1) return true;
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}