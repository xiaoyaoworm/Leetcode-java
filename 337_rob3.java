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


思路3： 优化空间复杂度，我们发现 其实答案就两种：一种有root一种没有root。只需要两个值，累加即可，最后比较这俩值哪个大即可。

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
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }
    
    public int[] robSub(TreeNode root) {
        if(root == null) return new int[2];
        
        int[] left = robSub(root.left); //left[0]: with left, left[1]: without left
        int[] right = robSub(root.right); //right[0]: with right, right[1]: without right
        
        int[] res = new int[2];
        //0: with root
        res[0] = root.val + left[1] + right[1];
        //1: without root
        res[1] = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}