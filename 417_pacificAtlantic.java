public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<int[]>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        //dont forget atlantic and pacific have two lines
        for(int i = 0; i < m; i++){
            dfs(matrix, pacific, matrix[i][0], i, 0);
            dfs(matrix, atlantic, matrix[i][n-1], i, n-1);
        }
        for(int j = 0; j < n; j++){
            dfs(matrix, pacific, matrix[0][j], 0, j);
            dfs(matrix, atlantic, matrix[m-1][j], m-1, j);
        }

        //find union
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]) res.add(new int[]{i,j});
            }
        }
        return res;
    }

    //height is last matrix point value!!!
    public void dfs(int[][] matrix, boolean[][] visited, int height, int i, int j){
        int m = matrix.length;
        int n = matrix[0].length;
        //dont forget check visited[i][j] and whether matrix[i][j] < height!!!!
        if(i < 0 || i>= m || j < 0 || j >= n || visited[i][j] || matrix[i][j] < height) return; 
        visited[i][j] = true;

        dfs(matrix, visited, matrix[i][j], i + 1, j);
        dfs(matrix, visited, matrix[i][j], i - 1, j);
        dfs(matrix, visited, matrix[i][j], i, j + 1);
        dfs(matrix, visited, matrix[i][j], i, j - 1);
    }
}