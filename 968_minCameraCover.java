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

// Greedy algo
// If leaf, return 0;
// If it is leaf's parent, needs camera and return 1
// If this is covered but no need to have camera, return 2
class Solution {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) res++;
        return res;
    }
    
    public int dfs(TreeNode root){
        if(root == null) return 2;
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        if(left == 0 || right == 0){ //Be attention this is OR!!!!!
            res++;
            return 1;
        }
        if(left == 1 || right == 1) return 2;
        return 0;
    }
}