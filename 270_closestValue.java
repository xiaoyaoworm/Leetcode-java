//Recursive解法也很直白，记录root.val == a. 用binary search去看走左边还是走右边，递归求解最接近的点的值。若kid == null可以直接返回root。
//若不为空，那么我们就做比较，看是kid更接近还是root更接近。

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
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = root.val < target ? root.right : root.left;
        if(kid == null) return a;
        int b = closestValue(kid, target);
        return Math.abs(a-target) < Math.abs(b-target) ? a: b;
    }
}


//Iterative解法，就很直白，每次看当前root这个是不是最接近target的，然后用binary search去看走左边还是走右边。

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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while(root!=null){
            if(Math.abs(root.val-target) < Math.abs(res-target)) res = root.val;
            if(root.val < target) root = root.right;
            else root = root.left;
        }
        return res;
    }
}