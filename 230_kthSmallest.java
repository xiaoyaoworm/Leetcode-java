Recursive

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int counter = 0;
    int number = 0;
    public int kthSmallest(TreeNode root, int k) {
        counter = k;
        helper(root);
        return number;
    }
    
    public void helper(TreeNode root){
        if(root.left!=null){
            helper(root.left);
        }
        counter--;
        if(counter == 0){
            number = root.val;
            return;
        }
        if(root.right!=null){
            helper(root.right);
        }
    }
}


Iterative:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(true){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            if(stack.isEmpty()){
                return 0;
            }
            TreeNode temp = stack.pop();
            k--;
            if(k == 0) return temp.val;
            if(temp.right!=null){
                p = temp.right;
            }
        }
    }
}