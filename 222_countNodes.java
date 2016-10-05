//下面是解题思路。
//这个是目前通过的解法。其实就是方法2中把两个while组合在一起，Math.pow(2,n) --> 1<<n 用位移来计算加速。
//注意如果是个满树，它的总结点应该是2^height-1
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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode l = root;
        TreeNode r = root;
        int height = 0;
        while(r!=null){ //r!=null
            l = l.left;
            r = r.right;
            height++;
        }
        
        if(l==null) return (1<<height)-1; //of course r will be null now, if l == null, means already reach end.
        return 1+countNodes(root.left)+countNodes(root.right); // else recursive
    }
}

/***********华丽丽的解题思路！！！*************/


//Naive解法：O(n)，完全没有利用到这个是complete tree这个先决条件。
public int countNodes(TreeNode root) {
    if (root == null)
        return 0;
    return 1 + countNodes(root.left) + countNodes(root.right);
}

//TLE解法。有大量的重复计算height！算法复杂度logn*logn
//T(n) == 2T(n/2) + 2logn = .....

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
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode l = root;
        TreeNode r = root;
        
        int hl = 0;
        int hr = 0;
        while(l!=null){
            l = l.left;
            hl++;
        }
        
        while(r!=null){
            r = r.right;
            hr++;
        }
        
        if(hl == hr) return (int)Math.pow(2, hl)-1;
        else return 1+countNodes(root.left)+countNodes(root.right);
    }
}

//TLE解法。有大量的重复计算height！算法复杂度logn*logn
//T(n) == 2T(n/2) + 2logn = .....

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
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode l = root;
        TreeNode r = root;
        
        int hl = 0;
        int hr = 0;
        while(l!=null){
            l = l.left;
            hl++;
        }
        
        while(r!=null){
            r = r.right;
            hr++;
        }
        
        if(hl == hr) return (int)Math.pow(2, hl)-1;
        else return 1+countNodes(root.left)+countNodes(root.right);
    }
}

//还是TLE的，但优化于上个方法。不用计算left的其实，因为每次left都是完全的，height-1递归下去。
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
    
    public int countNodes(TreeNode root) {
        int height = 0;
        TreeNode run = root;
        while(run!=null){
            run = run.left;
            height++;
        }
        return count(root, height);
    }
    
    public int count(TreeNode root, int height){
        if(root == null) return 0;
        TreeNode r = root;
        
        int hr = 0;

        while(r!=null){
            r = r.right;
            hr++;
        }
        
        if(height == hr) return (int)Math.pow(2, height)-1;
        else return 1+count(root.left, height-1)+count(root.right, height-1);
    }
}


//找到无法通过的症结了，如果用Math.pow所有的方法都会慢下来。。。。所以最好的办法用移位。。应该是1<<n = Math.pow(2,n)
//额 还是TLE的
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
    
    public int countNodes(TreeNode root) {
        int height = 0;
        TreeNode run = root;
        while(run!=null){
            run = run.left;
            height++;
        }
        return count(root, height);
    }
    
    public int count(TreeNode root, int height){
        if(root == null) return 0;
        TreeNode r = root;
        
        int hr = 0;

        while(r!=null){
            r = r.right;
            hr++;
        }
        
        if(height == hr) return (1<<height)-1;
        else return 1+count(root.left, height-1)+count(root.right, height-1);
    }
}





