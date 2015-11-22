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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(true){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            if(stack.isEmpty()) break;
            p = stack.pop();
            result.add(p.val);
            p = p.right;
        }
        return result;
    }
}