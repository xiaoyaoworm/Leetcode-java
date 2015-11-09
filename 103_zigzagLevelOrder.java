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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 1;
        int current = 1;
        int next = 0;
        
        List<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(depth%2==0){
                stack.push(temp.val);
            } else{
                list.add(temp.val);
            }
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
                if(depth%2==0){
                    while(!stack.isEmpty()){
                        list.add(stack.pop());
                    }
                    stack = new Stack<Integer>();
                }
                result.add(list);
                depth++;
                current = next;
                next = 0;
                list = new ArrayList<Integer>();
            }
        }
        return result;
    }
}