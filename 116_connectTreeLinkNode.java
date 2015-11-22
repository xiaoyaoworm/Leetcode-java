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
        if(root == null) return;
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        int current = 1;
        int next = 0;
        TreeLinkNode start = null;
        
        while(!queue.isEmpty()){
            TreeLinkNode temp = queue.remove();
            if(start == null) start = temp;
            else {
                start.next = temp;
                start = start.next;
            }
            if(temp.left!=null) {
                queue.add(temp.left);
                next++;
            }
            if(temp.right!=null) {
                queue.add(temp.right);
                next++;
            }
            current--;
            if(current == 0){
                current = next;
                next = 0;
                start.next = null;
                start = null;
            }
        }
    }
}