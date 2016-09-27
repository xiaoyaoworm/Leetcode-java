/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int len = 0;
        ListNode run = head;
        ListNode tail = null;
        while(run!=null){
            tail = run;
            run = run.next;
            len++;
        }
        k = k%len;
        if(k == 0) return head;
        
        run = head;
        int num = len-k-1;
        while(num > 0){
            run = run.next;
            num--;
        }
        ListNode newHead = run.next;
        run.next = null;
        tail.next = head;
        return newHead;
    }
}