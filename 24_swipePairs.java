Recursive解法

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

Iterative解法：
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
        ListNode fake = new ListNode(0);
        ListNode pre = fake;
        ListNode cur = head;
        
        while(cur!=null && cur.next!=null){
            ListNode next = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = next;
            pre = cur;
            cur = next;
            if(cur == null || cur.next == null) pre.next = cur;
        }
        
        return fake.next;
    }
}