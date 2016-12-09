public class Solution {
    public boolean isMatch(String s, String p) {
        if(p == null) return s == null;
        if(p.length() == 0) return s.length() == 0;
        
        if(p.length() == 1){
            if(p.equals("*")) return false;
            if(p.equals(".")) return s.length() == 1;
            return p.equals(s);
        }
        
        //p.length()>=2
        if(p.charAt(1) != '*'){
            if(s.length() == 0) return false;
            if(p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) return isMatch(s.substring(1), p.substring(1));
            return false;
        } else{
            if(isMatch(s,p.substring(2))) return true;
            int i = 0;
            while(i< s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
                if(isMatch(s.substring(i+1), p.substring(2))) return true;
                i++;
            }
        }
        return false;
    }
}

//Reference: https://discuss.leetcode.com/topic/40371/easy-dp-java-solution-with-detailed-explanation
// 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
// 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
// 3, If p.charAt(j) == '*': 
//    here are two sub conditions:
//                1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
//                2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
//                               dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
//                            or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
//                            or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty

public class Solution {
    public boolean isMatch(String s, String p) {
        if(p == null || s == null) return false;
        
        int m = s.length();
        int n = p.length();
        
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        
        for(int j = 0; j < n; j++){
            if(p.charAt(j) == '*' && dp[0][j-1]) dp[0][j+1] = dp[0][j-1]; 
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') dp[i+1][j+1] = dp[i][j];
                if(p.charAt(j) == '*'){
                  if(s.charAt(i)!=p.charAt(j-1) && p.charAt(j-1)!='.') dp[i+1][j+1] = dp[i+1][j-1];  
                  else{
                      dp[i+1][j+1] = (dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1]);
                  }
                } 
            }
        }
        return dp[m][n];
    }
}