public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        Comparator<int[]> comparator = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]!=b[0]) return a[0]-b[0];
                return a[1]-b[1];
            }
        };
        
        Arrays.sort(points, comparator);
        
        int arrow = 1;// not 0
        int limit = points[0][1];
        for(int i = 1; i < points.length;i++){
            int[] current = points[i];
            if(current[0] <= limit){ // <= not only <
                limit = Math.min(limit, current[1]);
            } else{
                arrow++;
                limit = current[1];
            }
        }
        return arrow;
    }
}