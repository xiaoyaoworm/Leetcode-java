/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode runA = headA;
        ListNode runB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while(runA!=null){
            runA = runA.next;
            lengthA++;
        }
        while(runB!=null){
            runB = runB.next;
            lengthB++;
        }
        int gap = lengthA-lengthB;
        if(gap >= 0){
            while( gap > 0){
                headA = headA.next;
                gap--;
            }
        } else{
            while( gap < 0){
                headB = headB.next;
                gap++;
            }
        }
        
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}