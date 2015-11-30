public class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            int current = Math.min(height[left],height[right])*(right-left);
            result = Math.max(result,current);
            if(height[left]<height[right]){
                left++;
            } else if(height[left]>height[right]){
                right--;
            } else{
                left++;
                right--;
            }
        }
        return result;
    }
}