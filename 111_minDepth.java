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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int current = 1;
        int next = 0;
        int depth = 1;
        
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp.left == null && temp.right == null) return depth;
            if(temp.left!=null){
                queue.add(temp.left);
                next++;
            }
            if(temp.right!=null){
                queue.add(temp.right);
                next++;
            }
            current--;
            if(current == 0){
                depth++;
                current = next;
                next = 0;
            }
        }
        return 0;
    }
}