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
    public void flatten(TreeNode root) {
        if(root!=null){
            root = flattenRoot(root);
        }
    }
    
    public TreeNode flattenRoot(TreeNode root){
        TreeNode last = root;
        
        TreeNode left = root.left;
        TreeNode right = root.right; 
        root.left = null;
        root.right = null; // Copy two object to other places and reset root
        
        if(left!=null){
            last.right = left;
            last = flattenRoot(left);
        }
        if(right!=null){
            last.right = right;
            last = flattenRoot(right);
        }
        return last;
    }
}