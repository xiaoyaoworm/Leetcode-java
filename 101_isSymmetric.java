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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return compareSymmetric(root.left,root.right);
    }
    
    public boolean compareSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val!=right.val) return false;
        return compareSymmetric(left.left, right.right)&& compareSymmetric(left.right, right.left);
    }
}