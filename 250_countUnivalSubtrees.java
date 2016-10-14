//if one node's left or right subtree is already not a unival subtree, of course current node's subtree is not.
//so do dfs in the beginning, this is like a post order traversal.

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
    public int countUnivalSubtrees(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }
    
    public boolean dfs(TreeNode root, int[] res){
        if(root == null) return true;
        boolean left = dfs(root.left, res);
        boolean right = dfs(root.right, res);
        if(left && right){
            if(root.left!=null && root.val!=root.left.val) return false;
            if(root.right!=null && root.val!=root.right.val) return false;
            res[0]++;
            return true;
        }
        return false;
    }
}