public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return true;
        
        p = simplifyPattern(p);

        int sl = s.length();
        int pl = p.length();
        
        boolean[][] dp = new boolean[sl+1][pl+1];
        dp[0][0] = true;
        
        // for(int i = 1; i <= sl; i++){
        //     dp[i][0] = false;
        // }
        
        for(int j = 1; j <= pl; j++){
            if(p.charAt(j-1) == '*') dp[0][j] = true;
            else break;
        }
        
        for(int i = 1; i <= sl; i++){
            for(int j = 1; j <= pl; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else dp[i][j] = false;
            }
        }
        return dp[sl][pl];
    }

    public String simplifyPattern(String p){ //Used to handle multiple ***** scenario, simplify it to one *
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < p.length(); i++){
            if(i>1 && p.charAt(i) == '*' && p.charAt(i-1) == '*') continue;
            sb.append(p.charAt(i));
        }
        return sb.toString();
    }
}



基于space的优化，其实还可以进一步优化成线性。比较好理解的是现在的：我们还是用二维数组，但我们只要两行即可：
public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return true;
        
        p = simplifyPattern(p);
        
        int sl = s.length();
        int pl = p.length();
        
        boolean[][] dp = new boolean[2][pl+1];
        dp[0][0] = true;
        
        for(int j = 1; j <= pl; j++){
            if(p.charAt(j-1) == '*') dp[0][j] = true;
            else break;
        }
        
        for(int i = 1; i <= sl; i++){
            for(int j = 1; j <= pl; j++){
                if(i!=1) dp[0][0] = false; //把下面的所有false全部挪上来，只有第一行初始是true。
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') dp[1][j] = dp[0][j-1];
                else if(p.charAt(j-1) == '*') dp[1][j] = dp[0][j] || dp[1][j-1];
                else dp[1][j] = false;
            }
            copy(dp);
        }
        return dp[0][pl];//因为我们最后做了一步copy，所有的都上移了，所以我们返回第一行的末尾boolean即可。
    }
    
    private void copy(boolean[][] dp){//用来把第二行copy去第一行。其实可以无视第二行的结果的。如果不设置第二行为false，上一段可以返回dp[1][pl]的。
        for(int i = 0; i < dp[0].length; i++){
            dp[0][i] = dp[1][i];
            dp[1][i] = false;
        }
    }
    
    public String simplifyPattern(String p){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < p.length(); i++){
            if(i>1 && p.charAt(i) == '*' && p.charAt(i-1) == '*') continue;
            sb.append(p.charAt(i));
        }
        return sb.toString();
    }
}