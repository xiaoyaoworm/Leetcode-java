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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(root,result,0);
        return result;
    }
    
    
    public void dfs(TreeNode root, List<Integer> result, int depth){
        if(root == null) return;
        if(depth == result.size()){
            result.add(root.val);
        }
        dfs(root.right,result,depth+1);
        dfs(root.left,result,depth+1);
    }
}