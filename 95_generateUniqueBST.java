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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<TreeNode>();
        return generate(1,n);
    }
    
    public List<TreeNode> generate(int start, int end){
        List<TreeNode> result = new LinkedList<TreeNode>();
        if(start > end){
            result.add(null);
            return result;
        }
        for(int i = start; i <= end; i++){
           List<TreeNode> leftList = generate(start, i-1);
           List<TreeNode> rightList = generate(i+1,end);
           for(TreeNode left: leftList){
               for(TreeNode right: rightList){
                   TreeNode temp = new TreeNode(i);
                   temp.left = left;
                   temp.right = right;
                   result.add(temp);
               }
           }
        }
        return result;
    }
}