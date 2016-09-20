public class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        Collections.sort(cols);
        
        return minDistance(rows)+minDistance(cols);
    }
    
    public int minDistance(List<Integer> list){
        int res = 0;
        if(list == null || list.size() == 0) return res;
        
        int i = 0;
        int j = list.size()-1;
        
        while(i<j){
            res+=list.get(j)-list.get(i);
            i++;
            j--;
        }
        return res;
    }
}