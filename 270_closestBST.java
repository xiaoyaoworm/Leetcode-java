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
    double gap = Double.MAX_VALUE;
    int result = 0;
    public int closestValue(TreeNode root, double target) {
        helper(root,target);
        return result;
    }
    
    public void helper(TreeNode root, double target){
        if(root == null) return;
        if(Math.abs(root.val - target)<gap){
            result = root.val;
            gap = Math.abs(root.val - target);
        }
        if(root.val<target){
            helper(root.right,target);
        }
        if(root.val>target){
            helper(root.left,target);
        }
    }
}