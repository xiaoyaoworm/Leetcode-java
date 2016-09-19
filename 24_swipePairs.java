Recursive解法：O(N) space:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode third = second.next;
        second.next = head;
        head.next = swapPairs(third);
        return second;
    }
}


Iterative解法：O(1) space
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        
        ListNode pre = fakeHead;
        ListNode cur = head;
        
        while(cur!=null && cur.next!=null){
            ListNode next = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            
            pre = cur;
            cur = next;
        }
        return fakeHead.next;
    }
}