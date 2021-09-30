/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode[] nodes = split(head);
        ListNode l = sortList(nodes[0]);
        ListNode r = sortList(nodes[1]);
        return merge(l,r);
    }
    
    public ListNode[] split(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head; //Add dummy in front to make sure slow would be the mid!
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode r = slow.next;
        ListNode l = dummy.next;
        slow.next = null;
        ListNode[] res = new ListNode[2];
        res[0] = l;
        res[1] = r;
        return res;
    }
    
    public ListNode merge(ListNode l, ListNode r){
        ListNode dummy = new ListNode(0);
        ListNode run = dummy;
        while(l != null && r != null){
            if(l.val < r.val){
                run.next = new ListNode(l.val);
                l = l.next;
            } else{
                run.next = new ListNode(r.val);
                r = r.next;
            }
            run = run.next;
        }
        if(l != null){
            run.next = l;
        }
        if(r != null){
            run.next = r;
        }
        return dummy.next;
    }
}