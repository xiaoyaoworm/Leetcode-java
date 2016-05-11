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
    int maxSum = Integer.MIN_VALUE;//not 0!!
    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return maxSum;
    }
    
    public int oneSideMax(TreeNode root){
        if(root == null) return 0;
        int l = oneSideMax(root.left);
        int r = oneSideMax(root.right);
        maxSum = Math.max(maxSum,root.val+Math.max(l,0)+Math.max(r,0));//Dont forget 0!!!!
        return root.val+Math.max(0,Math.max(l,r)); //Dont forget 0!!!!
    }
}