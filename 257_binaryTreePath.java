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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        dfs(root, "", result);
        return result;
    }
    
    public void dfs(TreeNode node, String str, List<String> result){
        if(node == null) return;
        if(str.length() == 0) str = str+node.val;
        else str = str+"->"+node.val;
        
        if(node.left == null && node.right == null) result.add(str);
        dfs(node.left,str,result);
        dfs(node.right,str,result);
    }
}