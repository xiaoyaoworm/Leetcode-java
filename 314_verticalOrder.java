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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;

        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> cols = new LinkedList<Integer>();

        q.add(root);
        cols.add(0);

        int min = 0;
        int max = 0;

        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            int col = cols.remove();

            List<Integer> list = map.get(col);
            if(list == null) list = new ArrayList<Integer>();
            list.add(temp.val);
            map.put(col,list);

            if(temp.left!=null){
                q.add(temp.left);
                cols.add(col-1);
                min = Math.min(min, col-1);
            }

            if(temp.right!=null){
                q.add(temp.right);
                cols.add(col+1);
                max = Math.max(max, col+1);
            }
        }
        for(int i = min; i <= max; i++){
            result.add(map.get(i));
        }
        return result;
    }
}