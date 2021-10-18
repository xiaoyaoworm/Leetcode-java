/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        HashMap<TreeNode, TreeNode> isChildren = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        boolean findX = false;
        boolean findY = false;
        isChildren.put(root, null);
        TreeNode xn = null;
        TreeNode yn = null;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.remove();
                if(cur.val == x){
                    findX = true;
                    xn = cur;
                }
                if(cur.val == y){
                    findY = true;
                    yn = cur;
                }
                if(findX && findY && isChildren.get(xn)!= isChildren.get(yn)){
                    return true;
                }
                if(cur.left != null){
                    queue.add(cur.left);
                    isChildren.put(cur.left, cur);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                    isChildren.put(cur.right, cur);
                }
            }
            if(findX != findY) return false;
        }
         return false;       
    }   
}