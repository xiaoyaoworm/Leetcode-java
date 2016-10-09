//BFS解法:
//Attention: we are looking for left !!!leave!!! node sum

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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0; // dont forget!!!!!
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        int res = 0;
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp.left!=null){
                queue.add(temp.left);
                
                if(temp.left.left == null && temp.left.right == null) res+=temp.left.val; //looking for left leave!!!!
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
        return res;
    }
}


