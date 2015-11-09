/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode fakeNode = new ListNode(0);
        ListNode run = fakeNode;
        
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                run.next = l1;
                l1 = l1.next;
            } else{
                run.next = l2;
                l2 = l2.next;
            }
            run = run.next;
        }
        
        if(l1!=null){
            run.next = l1;
        }
        if(l2!=null){
            run.next = l2;
        }
        return fakeNode.next;
    }
}