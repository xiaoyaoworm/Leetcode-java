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
    Integer prev = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, list);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    
    public void dfs(TreeNode root,  List<Integer> list){
        if(root == null) return;
        dfs(root.left, list);
        if(prev != null){
            if(prev == root.val) count++;
            else count = 1;
        }
        if(count == max){
            list.add(root.val);
        }
        else if(count > max){
            max = count;
            list.clear();
            list.add(root.val);
        }
        prev = root.val;
        dfs(root.right, list);
    }
}