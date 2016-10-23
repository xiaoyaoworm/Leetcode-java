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
    int nodes = 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int[] count = new int[]{0}; //Key Point is here, we want to use some data which is Object!!!
        if(validateBST(root,min,max,count)) nodes = Math.max(nodes, count[0]);
        else nodes = Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
        return nodes;
    }
    
    public boolean validateBST(TreeNode root, int min, int max, int[] count){
        if(root == null) return true;
        count[0]++;
        if(root.val < min || root.val > max) return false;
        return validateBST(root.left, min, root.val, count) && validateBST(root.right, root.val, max, count);
    }
    
}