public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int x = 0;
        int y = 0;
        int step = 0;
        int k = 1;
        while(k<= n*n){
            while(y+step<n){ // Be careful for all the conditions!!!!
                result[x][y] = k;
                y++;
                k++;
            }
            y--;
            x++;
            while(x+step<n){
                result[x][y] = k;
                x++;
                k++;
            }
            x--;
            y--;
            while(y>=step){
                result[x][y] = k;
                y--;
                k++;
            }
            y++;
            x--;
            step++; //Most Important!!!!!!!!!!!!
            while(x>=step){
                result[x][y] = k;
                x--;
                k++;
            }
            x++;
            y++;
        }
        return result;
    }
}