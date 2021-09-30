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
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        oneside(root);
        return max;
    }
    
    public int oneside(TreeNode root){
        if(root == null) return 0;
        int left = oneside(root.left);
        int right = oneside(root.right);
        max = Math.max(max, left+right);
        return 1 + Math.max(left, right);
    }
}