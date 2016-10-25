// top = search row [0...x], find first row contain 1,
// bottom = search row[x+1, row], find first row contian all 0
// left = search col[0...y], find first col contain 1,
// right = search col[y+1, col], find first col contain all 0

//See Ref here: https://discuss.leetcode.com/topic/29006/c-java-python-binary-search-solution-with-explanation


public class Solution {
    private char[][] image;
    
    public int minArea(char[][] image, int x, int y) {
        this.image = image;
        int m = image.length;
        int n = image[0].length;
        
        int left = findColumn(0,y,0,m,true);
        int right = findColumn(y+1,n, 0, m, false);
        int top = findRow(0,x,0,n,true);
        int bottom = findRow(x+1,m, 0,n,false);
        return (right-left)*(bottom-top);
    }
    
    public int findColumn(int i, int j, int top, int bottom, boolean opt){
        while(i<j){
            int mid = i+(j-i)/2;
            int k = top;
            while(k<bottom){
                if(image[k][mid] == '1') break;
                k++;
            }
            if(k< bottom == opt){
                j = mid;
            } else{
                i = mid+1;
            }
        }
        return i;
    }
    
    public int findRow(int i, int j, int left, int right, boolean opt){
        while(i<j){
            int mid = i+(j-i)/2;
            int k = left;
            while(k < right){
                if(image[mid][k] == '1') break;
                k++;
            }
            if(k<right == opt){
                j = mid;
            } else{
                i = mid+1;
            }
        }
        return i;
    }
}