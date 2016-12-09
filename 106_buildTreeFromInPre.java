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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length!= postorder.length) return null;
        int len = inorder.length;
        return build(inorder, 0, len-1, postorder, 0, len-1);
    }
    
    public TreeNode build(int[] inorder, int in_start, int in_end, int[] postorder, int post_start, int post_end){
        if(in_start > in_end || post_start > post_end) return null;
        TreeNode root = new TreeNode(postorder[post_end]);
        
        int k = 0;
        while(inorder[in_start+k]!= root.val){
            k++;
        }
        
        root.left = build(inorder, in_start, in_start+k-1, postorder, post_start, post_start+k-1);
        root.right = build(inorder, in_start+k+1, in_end, postorder, post_start+k, post_end-1);
        return root;
    }
}