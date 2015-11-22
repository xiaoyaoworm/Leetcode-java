/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        
        //reverse
        ListNode p1 = second;
        ListNode p2 = p1.next;
        while(p1!=null && p2!=null){
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        second.next = null;
        
        if(p2 == null) second = p1;
        else second = p2;
        while(second!=null){
            if(head.val!=second.val) return false;
            head = head.next;
            second = second.next;
        }
        return true;
        
    }
}