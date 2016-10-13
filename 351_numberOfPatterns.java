//Ref: https://discuss.leetcode.com/topic/46260/java-dfs-solution-with-clear-explanations-and-optimization-beats-97-61-12ms
//这道题还蛮难的。但是是一道很好的题目。需要在思考一下，详情见上述链接！！

public class Solution {
    // cur: the current position
    // remain: the steps remaining
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        int res = 0;
        boolean[] visit = new boolean[10];
        for(int i = m; i <= n; i++){
            res += dfs(visit, skip, 1, i-1)*4; // 1, 3, 7, 9 are symmetric
            res += dfs(visit, skip, 2, i-1)*4; // 2, 4, 6, 8 are symmetric
            res += dfs(visit, skip, 5, i-1);   // 5
        }
        return res;
    }
    
    public int dfs(boolean[] visit, int[][] skip, int cur, int remain){
        if(remain == 0) return 1;
        visit[cur] = true;
        int res = 0;
        for(int i = 1; i <= 9; i++){
            // If vis[i] is not visited and (two numbers are adjacent or skip number is already visited)
            if(!visit[i] && (skip[i][cur] == 0 || visit[skip[i][cur]])){
                res+=dfs(visit, skip, i, remain-1);
            }
        }
        visit[cur] = false;//backtracking!!!
        return res;
    }
}