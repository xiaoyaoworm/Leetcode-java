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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        getHeight(root, res);
        return res;
    }
    
    //Bottom-up
    public int getHeight(TreeNode root, List<List<Integer>> res){
        if(root == null) return -1;//注意null是-1！！！！
        int level = 1+Math.max(getHeight(root.left,res),getHeight(root.right,res));
        if(res.size() == level) res.add(new ArrayList<Integer>()); //巧妙的添加一个新的！！！！
        res.get(level).add(root.val);
        root.left = null;//别忘记删除这个叶节点
        root.right = null;
        return level;
    }
}