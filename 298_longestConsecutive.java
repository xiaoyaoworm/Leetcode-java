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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0, root.val);
        return max;
    }
    
    public void dfs(TreeNode root, int current, int target){
        if(root == null) return;
        if(root.val == target) current++;
        else current = 1;
        max = Math.max(max, current);
        dfs(root.left, current, root.val+1);
        dfs(root.right, current, root.val+1);
    }
}