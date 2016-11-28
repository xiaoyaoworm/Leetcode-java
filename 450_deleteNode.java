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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val > key) {
            root.left = deleteNode(root.left, key); //set it as left!
        }
        else if(root.val < key) {
            root.right = deleteNode(root.right, key); //set it as right!
        }
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            
            TreeNode next = findMin(root.right); //find right's smallest node
            root.val = next.val;
            root.right = deleteNode(root.right, next.val); //set it as right!
        }
        return root;
    }
    
    public TreeNode findMin(TreeNode root){
        while(root.left!= null){ //here is root.left! not root!! we are looking for smallest leave node
            root = root.left;
        }
        return root;
    }
}