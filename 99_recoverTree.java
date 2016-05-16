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
    
    TreeNode prefix = null;
    TreeNode first = null;
    TreeNode second = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prefix == null){
            prefix = root;
        } else{
            if(prefix.val > root.val){
                if(first == null){
                    first = prefix;
                } 
                second = root; // not put it into else, it may switch consecautive two TreeNode value
            }
            prefix = root;
        }
        inorder(root.right);
    }
}