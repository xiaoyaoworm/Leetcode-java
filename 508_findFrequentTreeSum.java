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
    HashMap<Integer, Integer> map = new HashMap<>();
    int max = 0;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        
        dfs(root);
        List<Integer> list = new ArrayList();
        for(int i: map.keySet()){
            if(max == map.get(i)){
                list.add(i);
            }
        }
        
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int sum = l+r+root.val;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}