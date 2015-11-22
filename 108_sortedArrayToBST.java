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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    
    public TreeNode helper(int[] nums, int start, int end){
        TreeNode n = null;
        int mid = 0;
        if(start == end){
            n = new TreeNode(nums[start]);
            return n;
        }
        if(start < end){
            mid = start+(end-start)/2; // Cannot define mid here!!!!
            n = new TreeNode(nums[mid]);
            n.left = helper(nums,start,mid-1);
            n.right = helper(nums,mid+1,end);
        }
        return n; // must be written here rather then in if(start<end) condition. 
    }
}