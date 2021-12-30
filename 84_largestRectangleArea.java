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

//这里有个更好理解的版本：O(n) because to find the first left and right larger than current bar, it is jumping rather than move one by one 
//https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
          return 0;
        }
        
        int[] lessFromLeft = new int[heights.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[heights.length]; // idx of the first bar the right that is lower than current
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;

            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p]; //Jump rather than move one by one
            }
            lessFromLeft[i] = p;
        }

        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }
}