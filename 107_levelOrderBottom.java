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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int current = 1;
        int next = 0;
        
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            list.add(temp.val);
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
                stack.push(list);
                current = next;
                next = 0;
                list = new ArrayList<Integer>();
            }
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
}