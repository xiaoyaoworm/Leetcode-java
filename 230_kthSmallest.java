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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k == 0) return 0;
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(true){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            if(stack.isEmpty()){
                break;
            }
            TreeNode temp = stack.pop();
            k--;
            if(k == 0){
                return temp.val;
            }
            if(temp.right!=null){
                p = temp.right;
            }
        }
        return 0;
    }
}