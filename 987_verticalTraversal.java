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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer,List<Integer>>> map = new HashMap<>();
        dfs(0,0,root, map);
        List<Integer> cols = new ArrayList(map.keySet());
        Collections.sort(cols);
        List<List<Integer>> res = new ArrayList();
        for(int col: cols){
            List<Integer> rows = new ArrayList(map.get(col).keySet());
            Collections.sort(rows);
            List<Integer> temp = new ArrayList();
            for(int row: rows) {
                List<Integer> values = map.get(col).get(row);
                Collections.sort(values);
                temp.addAll(values);
            }
            res.add(temp);
        }
        return res;
    }
    
    public void dfs(int x, int y, TreeNode root, Map<Integer, Map<Integer,List<Integer>>> map){
        if(root == null) return;
        map.putIfAbsent(y, new HashMap());
        map.get(y).putIfAbsent(x, new ArrayList());
        map.get(y).get(x).add(root.val);
        dfs(x+1, y-1, root.left, map);
        dfs(x+1, y+1, root.right, map);
    }
}