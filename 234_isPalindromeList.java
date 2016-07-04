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
        // Be careful, it is checkint fast.next and fast.next.next!!!!!!
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode first = head;
        
        second = reverse(second);
        
        // use second because first may have one more node than second
        while(second!=null){
            if(first.val!=second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode p = head;
        ListNode q = head.next;
        head.next = null;
        while(p!=null && q!=null){
            ListNode next = q.next;
            q.next = p;
            p = q;
            if(next!=null) q = next;
            else break;
        }
        return q;
    }
}