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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
            if(Math.abs(getDepth(temp.left)-getDepth(temp.right))<=1){
                continue;
            } else{
                return false;
            }
        }
        return true;
    }
    
    public int getDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}