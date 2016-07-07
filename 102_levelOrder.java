BFS:

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int current = 1;
        int next = 0;
        List<Integer> list = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            current --;
            list.add(temp.val);
            
            if(temp.left!=null) {
                queue.add(temp.left);
                next++;
            }
            if(temp.right!=null){
                queue.add(temp.right);
                next++;
            }
            
            if(current == 0){
                result.add(list);
                list = new ArrayList<Integer>();
                current = next;
                next = 0;
            }
        }
        return result;
    }
}



DFS:
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(root, result, 0);
        return result;
    }
    
    public void dfs(TreeNode root, List<List<Integer>> result, int level){
        if(root == null) return;
        if(level >= result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        
        dfs(root.left,result,level+1);
        dfs(root.right,result,level+1);
    }
}