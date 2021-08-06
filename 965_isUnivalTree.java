/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return isUnivalTree(root, root.val);
    }
    
    public boolean isUnivalTree(TreeNode root, int v){
        if (root == null) return true;
        if (root.val != v) return false;
        return isUnivalTree(root.left, root.val) && isUnivalTree(root.right, root.val);
    }
}