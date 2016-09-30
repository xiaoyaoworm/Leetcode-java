//这道题挺难的。这种解法是O(N)解法。还有最常规的O(n^2) bruce force和 divide conquer的优化nlogn解法。详情请看geeksforgeeks： http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
//O(N)此处解法请参考如下内容：
//https://discuss.leetcode.com/topic/7599/o-n-stack-based-java-solution
//https://www.youtube.com/watch?v=VNbkzsnllsU
//http://www.geeksforgeeks.org/largest-rectangle-under-histogram/


public class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        if(heights == null || heights.length == 0) return res;
        
        int len = heights.length;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i <= len; i++){
            int h = (i==len ? 0: heights[i]);
            if(stack.isEmpty() || h > heights[stack.peek()]){
                stack.push(i);
            } else{
                int index = stack.pop();
                int col = 0;
                if(stack.isEmpty()) col = i;
                else col = i-1-stack.peek();
                res = Math.max(res, col* heights[index]);
                i--; //don't forget, we should not only calculate previous area, needs to add this height[i] in it.
            }
        }
        return res;
    }
}