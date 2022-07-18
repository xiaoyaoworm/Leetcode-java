class Solution {
    public int trap(int[] height) {
        int res = 0;
        int start = 0;
        int end = height.length-1;
        
        while(start < end && height[start+1] >= height[start]){
            start++;
        }
        while(start < end && height[end-1] >= height[end]){
            end--;
        }
        
        while(start < end){
            int left = height[start];
            int right = height[end];
            if(left <= right){
                while(start < end && height[++start] < left){
                    res += left- height[start];
                }
            } else{
                while(start < end && height[--end] < right){
                    res += right- height[end];
                }
            }
        }
        return res;
    }
}