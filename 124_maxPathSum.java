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
    public int max = Integer.MIN_VALUE;// not 0!!!!
    public int maxPathSum(TreeNode root) {
        oneSide(root);
        return max;
    }
    
    public int oneSide(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, oneSide(root.left));
        int right = Math.max(0, oneSide(root.right));
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}