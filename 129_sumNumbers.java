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
    public int sumNumbers(TreeNode root) {
        return calculate(root,0);
    }
    
    public int calculate(TreeNode root, int sum){
        if(root == null) return 0;// this is 0 not sum!!!!
        sum = sum*10+root.val; //update sum
        if(root.left == null && root.right == null) return sum;
        return calculate(root.left,sum) + calculate(root.right, sum);
    }
}