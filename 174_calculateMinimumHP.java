//小于1的情况，即为死，所以需要一个Math.max(current, 1)的比较，保证每个点都不死。
//然后dp从右下角开始，给出所在列和所在行的dp值，然后不断判断，取最小值。找到左上角点的最小值。

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] health = new int[m][n];
        health[m-1][n-1] = Math.max(1-dungeon[m-1][n-1], 1);
        
        for(int i = m-2; i>=0; i--){
            health[i][n-1] = Math.max(health[i+1][n-1]-dungeon[i][n-1],1);
        }
        
        for(int i = n-2; i>=0; i--){
            health[m-1][i] = Math.max(health[m-1][i+1]-dungeon[m-1][i],1);
        }
        
        for(int i = m-2; i>=0; i--){
            for(int j = n-2; j>=0; j--){
                int down = Math.max(health[i+1][j]-dungeon[i][j], 1);
                int right = Math.max(health[i][j+1]-dungeon[i][j],1);
                health[i][j] = Math.min(down,right);
            }
        }
        return health[0][0];
    }
}