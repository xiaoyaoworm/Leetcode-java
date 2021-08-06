//Best solution: Calculate weight then check the Math.abs(l-r), if -1 set as -1 forever.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
    
    public int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        
        if (left == -1 || right == -1 || Math.abs(left-right) >1) return -1;
        return Math.max(left, right)+1;
    }
}

//Use BFS to check balanced:

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


//Use DFS to check balanced:
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
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if((Math.abs(left-right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}