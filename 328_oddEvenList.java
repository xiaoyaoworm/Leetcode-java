/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);
        oddDummy.next = head;
        evenDummy.next = head.next;
        ListNode oddRun = head;
        ListNode evenRun = head.next;
        while(evenRun!=null && evenRun.next!=null){
            oddRun.next = evenRun.next;
            evenRun.next = evenRun.next.next;
            oddRun = oddRun.next;
            evenRun = evenRun.next;
        }
        oddRun.next = evenDummy.next;
        return oddDummy.next;
    }
}