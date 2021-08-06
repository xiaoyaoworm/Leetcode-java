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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return subRoot == null;
        if(isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public boolean isSame(TreeNode m, TreeNode n){
        if(m == null && n == null) return true;
        if(m == null || n == null) return false;
        if(m.val != n.val) return false;
        return isSame(m.left, n.left) && isSame(m.right, n.right);
    }
}