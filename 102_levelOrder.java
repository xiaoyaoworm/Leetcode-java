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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        List<Integer> currentList = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int current = 1;
        int next = 0;
        
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp.left!=null){
                queue.add(temp.left);
                next++;
            }
            if(temp.right!=null){
                queue.add(temp.right);
                next++;
            } // Add those at first then calculate current value
            current--;
            currentList.add(temp.val);
            if(current == 0){
                result.add(currentList);
                currentList = new ArrayList<Integer>();
                current = next;
                next = 0;
            }
        }
        return result;
    }
}