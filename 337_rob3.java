还有思路3: TODO

思路1：
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
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int val = 0;
        
        if(root.left!=null) {
            val+=rob(root.left.left);
            val+=rob(root.left.right);
        }
        if(root.right!=null) {
            val+=rob(root.right.left);
            val+=rob(root.right.right);
        }
        
        return Math.max(root.val+val, rob(root.left)+rob(root.right));
    }
}



思路2：用hashmap优化：
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
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        return rob(root,map);
    }
    
    private int rob(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int val = 0;
        
        if(root.left!=null) {
            val+=rob(root.left.left, map);
            val+=rob(root.left.right, map);
        }
        if(root.right!=null) {
            val+=rob(root.right.left, map);
            val+=rob(root.right.right, map);
        }
        
        int result = Math.max(root.val+val, rob(root.left, map)+rob(root.right, map));
        map.put(root, result);
        return result;
    }
}