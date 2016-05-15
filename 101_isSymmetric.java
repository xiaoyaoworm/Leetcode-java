Recursive:

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return compare(root.left,root.right);
    }
    
    public boolean compare(TreeNode p1, TreeNode p2){
        if(p1 == null && p2 == null) return true;
        if(p1 == null || p2 == null) return false;
        if(p1.val!=p2.val) return false;
        return compare(p1.left,p2.right) && compare(p1.right,p2.left);
    }
}


Iterative:

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(root);
        q2.add(root);
        
        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode temp1 = q1.remove();
            TreeNode temp2 = q2.remove();
            if(temp1 == null && temp2 == null) continue;
            if(temp1 == null || temp2 == null) return false;
            if(temp1.val != temp2.val) return false;
            q1.add(temp1.left);
            q1.add(temp1.right);
            q2.add(temp2.right);
            q2.add(temp2.left);
        }
        if(!q1.isEmpty() || !q2.isEmpty()){
            return false;
        }
        return true;
    }
}