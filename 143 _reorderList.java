/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode r = slow.next;
        slow.next = null;
        ListNode first = head;
        ListNode second = reverse(r);
        
        combine(first, second);
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        head.next = null;
        
        while(p1!=null && p2!=null){
            ListNode temp = p2.next;
            p2.next = p1;
            
            p1 = p2;
            if(temp!=null){
                p2 = temp;
            } else break;
        }
        return p2;
    }
    
    public void combine(ListNode l1, ListNode l2){
        while(l2!=null){
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l2.next = temp1;
            
            l1 = temp1;
            l2 = temp2;
        }
    }
}