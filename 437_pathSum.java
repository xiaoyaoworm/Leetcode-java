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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap();
        dfs(root, targetSum, map, 0);
        return count;
    }
    
    public void dfs(TreeNode root, int targetSum, HashMap<Integer, Integer> map, int currentSum){
        if(root == null) return;
        currentSum += root.val;
        if(currentSum == targetSum) count++;
        count += map.getOrDefault(currentSum-targetSum, 0);
        map.put(currentSum, map.getOrDefault(currentSum, 0)+1);
        dfs(root.left, targetSum, map, currentSum);
        dfs(root.right, targetSum, map, currentSum);
        map.put(currentSum, map.get(currentSum)-1);
    }
}



//If the tree is balanced, then each node is reached from its ancestors (+ itself) only, which are up to log n. Thus, the time complexity for a balanced tree is O (n * log n).
//However, in the worst-case scenario where the binary tree has the same structure as a linked list, the time complexity is indeed O (n ^ 2).

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
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum); //Recursive for all notes with sum
    }
    
    public int dfs(TreeNode root, int sum){
        int res = 0;
        if(root == null) return res;
        if(root.val == sum){
            res++;
        }
        int left = dfs(root.left, sum-root.val);
        int right = dfs(root.right, sum-root.val);
        res += left;
        res += right;
        return res;
    }
}