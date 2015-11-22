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
    public boolean isValidBST(TreeNode root) {
        return validHelper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    public boolean validHelper(TreeNode root, double min, double max){
        if(root == null) return true;
        if(root.val >= max) return false;
        if(root.val <= min) return false;
        return validHelper(root.left, min, root.val) && validHelper(root.right, root.val, max);
    }
}