public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        
        for(int i = 0 ; i <= len1; i++){
            dp[i][0] = i; 
        }
        
        for(int j = 0; j <= len2; j++){
            dp[0][j] = j;
        }
        
        for(int i = 1; i <= len1; i++){
            char x = word1.charAt(i-1);
            for(int j = 1; j <=len2; j++){
                char y = word2.charAt(j-1);
                if(x == y){
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    int insert = dp[i-1][j]+1;
                    int remove = dp[i][j-1]+1;
                    int replace = dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(Math.min(insert,remove),replace);
                }
            }
        }
        return dp[len1][len2];
    }
}