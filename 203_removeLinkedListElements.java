/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode run = newHead;
        while(run!=null){
            while(run.next!=null && run.next.val == val){
                run.next = run.next.next;
            }
            run = run.next;
        }
        return newHead.next;
    }
}