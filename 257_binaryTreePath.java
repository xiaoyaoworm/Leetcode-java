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
        if(root == null) return result;
        dfs(root,new StringBuffer(),result);
        return result;
    }
    
    public void dfs(TreeNode root, StringBuffer sb, List<String> result){
        if(root.left==null && root.right == null){
            sb.append(root.val);
            result.add(sb.toString());
            return;
        }
        sb.append(root.val);
        sb.append("->");
        if(root.left!=null){
            dfs(root.left,new StringBuffer(sb),result);
        }
        if(root.right!=null){
            dfs(root.right,new StringBuffer(sb),result);
        }
    }
}



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
        String str = "";
        dfs(root,result,str);
        return result;
    }
    
    public void dfs(TreeNode root, List<String> result, String str){
        if(root == null) return;
        if(str.length() == 0){
            str += root.val;
        } else{
            str = str + "->" + root.val;
        }
        if(root.left == null && root.right == null){
            result.add(str);
            return;
        }
        dfs(root.left, result, str);
        dfs(root.right, result,str);
    }
}