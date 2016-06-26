更漂亮的更优解：
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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prefix = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        traverse(root);
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
    
    public void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        
        if(first == null && prefix.val >= root.val){
            first = prefix;
        }
        if(first!=null && prefix.val>=root.val){
            second = root;
        }
        prefix = root;
        
        traverse(root.right);
    }
}





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