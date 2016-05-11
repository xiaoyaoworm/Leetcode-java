/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int carry = 0;
        ListNode newHead = new ListNode(0);
        ListNode run = newHead;
        while(l1!=null || l2!= null || carry != 0){
            int a = 0;
            int b = 0;
            if(l1!=null) a = l1.val;
            if(l2!=null) b = l2.val;
            int sum = a+b+carry;
            run.next = new ListNode(sum%10);
            carry = sum/10;
            
            run = run.next;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        return newHead.next;
    }
}