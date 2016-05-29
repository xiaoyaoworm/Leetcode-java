public class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int result = 0;
        while(start < end){
            int current  = Math.min(height[start], height[end])*(end-start);
            result = Math.max(current, result);
            if(height[start]<height[end]){
                start++;
            } else{
                end--;
            }
        }
        return result;
    }
}