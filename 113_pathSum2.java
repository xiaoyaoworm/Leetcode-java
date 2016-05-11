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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(root,sum,0,list,result);
        return result;
    }
    
    public void dfs(TreeNode root, int sum, int current, List<Integer> list, List<List<Integer>> result){
        if(root == null) return;
        current += root.val;
        list.add(root.val);
        
        if(root.left == null && root.right == null && sum == current){
            List<Integer> copy = new ArrayList<Integer>(list);
            result.add(copy);
            return;
        }
        
        if(root.left!=null){
            dfs(root.left,sum,current,list,result);
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            dfs(root.right,sum,current,list,result);
            list.remove(list.size()-1);
        }
    }
}