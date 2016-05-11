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
        return buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int in_start, int in_end, int post_start, int post_end){
        if(in_start> in_end || post_start>post_end) return null;
        int rootVal = postorder[post_end];
        TreeNode root = new TreeNode(rootVal);
        
        int k = 0;
        while(inorder[in_start+k]!=rootVal){
            k++;
        }
        
        root.left = buildTree(inorder,postorder,in_start,in_start+k+1,post_start,post_start+k-1);
        root.right = buildTree(inorder,postorder,in_start+k+1,in_end,post_start+k,post_end-1);
        return root;
    }
}