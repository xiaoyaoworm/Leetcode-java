/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode current = head;
        ListNode nextNode = current.next;
        while(current!=null && nextNode!=null){
            if(current.val == nextNode.val){
                current.next = nextNode.next;
                nextNode = nextNode.next;
            } else{
                current = nextNode;
                nextNode = nextNode.next;
            }
        }
        return head;
    }
}