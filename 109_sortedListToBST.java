/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val); 
        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = head;
        while(fast!=null && fast.next!=null){
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        preSlow.next = null;
        ListNode first = head; 
        
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(first);
        root.right = sortedListToBST(second);
        return root;
    }
    
}