/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root== null || root.left == null) return;
        connectNode(root.left,root.right);
    }
    
    public void connectNode(TreeLinkNode p1,TreeLinkNode p2){
        p1.next = p2;
        if(p1.left!=null){
            connectNode(p1.left,p1.right);
            connectNode(p1.right,p2.left);
            connectNode(p2.left,p2.right);
        }
    }
}