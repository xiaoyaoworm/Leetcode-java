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
    int deepest = 0;
    
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        int[] sum = new int[1];
        dfs(root, 0, sum);
        return sum[0];
    }
    
    
    public void dfs(TreeNode root, int dep, int[] sum){
        if(root == null) return;
        if(dep > deepest){
            deepest = dep;
            sum[0] = 0;
        }
        if(dep == deepest){
            sum[0] += root.val;
        }
        dfs(root.left, dep+1, sum);
        dfs(root.right, dep+1, sum);
    }
}