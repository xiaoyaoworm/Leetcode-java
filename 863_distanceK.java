/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        find(root, target, map);
        dfs(root, target, k, res, 0, map);
        return res;
    }
    
    public int find(TreeNode root, TreeNode target, HashMap<TreeNode, Integer> map){
        if(root == null) return -1;
        if(root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target, map);
        if(left != -1) {
            map.put(root, left+1);
            return left+1;
        }
        int right = find(root.right, target, map);
        if(right != -1) {
            map.put(root, right+1);
            return right+1;
        }
        return -1;
    }
    
    public void dfs(TreeNode root, TreeNode target, int k, List<Integer> res, int length, HashMap<TreeNode, Integer> map){
        if(root == null) return;
        if(map.containsKey(root)) length = map.get(root);//Be attention this won't override -1 side
        if(length == k){
            res.add(root.val);
        }
        dfs(root.left, target, k, res, length+1, map);
        dfs(root.right, target, k, res, length+1, map);
    }
}/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        find(root, target, map);
        dfs(root, target, k, res, 0, map);
        return res;
    }
    
    public int find(TreeNode root, TreeNode target, HashMap<TreeNode, Integer> map){
        if(root == null) return -1;
        if(root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target, map);
        if(left != -1) {
            map.put(root, left+1);
            return left+1;
        }
        int right = find(root.right, target, map);
        if(right != -1) {
            map.put(root, right+1);
            return right+1;
        }
        return -1;
    }
    
    public void dfs(TreeNode root, TreeNode target, int k, List<Integer> res, int length, HashMap<TreeNode, Integer> map){
        if(root == null) return;
        if(map.containsKey(root)) length = map.get(root);//Be attention this won't override -1 side
        if(length == k){
            res.add(root.val);
        }
        dfs(root.left, target, k, res, length+1, map);
        dfs(root.right, target, k, res, length+1, map);
    }
}