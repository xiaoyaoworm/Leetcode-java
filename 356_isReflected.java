//find minX and maxX, mid must be middle of them,
//use String as set element is better. find whether reflection is there.
//O(N) time
public class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null || points.length == 0) return true;
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;

        int m = points.length;
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < m; i++){
            minX = Math.min(minX, points[i][0]);
            maxX = Math.max(maxX, points[i][0]);
            set.add(points[i][0]+":"+points[i][1]); //Use String in set is good!!
        }

        double midX = minX+((double)maxX-(double)minX)/2;
        for(int[] point: points){
            if(point[0] == midX) continue;
            int x = point[0];
            int y = point[1];
            int newX = (int)(midX+midX-x);
            String str = newX + ":" + point[1];
            if(!set.contains(str)) return false;
        }
        return true;
    }
}