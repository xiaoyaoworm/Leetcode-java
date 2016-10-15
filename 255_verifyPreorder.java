//O(N) space, O(N) time, there is one O(1) space solution here: ref: https://discuss.leetcode.com/topic/21217/java-o-n-and-o-1-extra-space
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> inorder = new Stack<Integer>();
        for(int v: preorder){
            if(!inorder.isEmpty() && inorder.peek() > v) return false; //Without this line, this is definitely convert preorder to inorder.
            //inorder is be ready so all the rest should larger than them, otherwise, return false.
            while(!stack.isEmpty() && v > stack.peek()){ //reverse smaller one(compare with current number) and add them into inorder
                inorder.push(stack.pop());
            }
            stack.push(v);
        }
        return true;
    }
}


//Recursive解法！！！
//Time: O(nlogn)   space: Recursive is not O(1) space, dont know how to calculate.
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length <= 1) return true;
        return verify(preorder, 0, preorder.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean verify(int[] preorder, int i, int j, int min, int max){
        if(i > j) return true;//null scenario
        int root = preorder[i];
        
        if(root < min || root > max) return false;
        
        int k = i; //start is i not i+1: if start is already > end, you rightIndex should be start instead of start + 1.
        while(k <= j && preorder[k] <= root){ // can be equal!
            k++;
        }
        
        return verify(preorder, i+1, k-1, min, root) && verify(preorder, k, j, root, max);
    }
}