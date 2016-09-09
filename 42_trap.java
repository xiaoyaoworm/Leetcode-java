public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3) return 0;
        int l = 0;
        int r = height.length-1;
        int res = 0;
        
        while(l<r && height[l] < height[l+1]) l++;
        while(l<r && height[r] < height[r-1]) r--;
        
        while(l<r){
            int left = height[l];
            int right = height[r];
            
            if(left <= right){
                while(l<r && height[++l]< left){
                    res += left-height[l];
                }
            } else{
                while(l<r && height[--r]< right){
                    res+= right-height[r];
                }
            }
        }
        return res;
    }
}