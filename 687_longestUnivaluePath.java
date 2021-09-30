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
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        oneSide(root);
        return max;
    }
    
    public int oneSide(TreeNode root){
        if(root == null) return 0;
        int l = oneSide(root.left);
        int r = oneSide(root.right);
        int realLeft = 0;
        int realRight = 0;
        if(root.left != null && root.left.val == root.val){
            realLeft = l+1;
        }
        if(root.right != null && root.right.val == root.val){
            realRight = r+1;
        }
        max = Math.max(max, realLeft+realRight);
        return Math.max(realLeft, realRight);
    }
}