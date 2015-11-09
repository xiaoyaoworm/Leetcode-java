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
        if(headA == null && headB == null) return null;
        int lengthA = 0;
        int lengthB = 0;
        ListNode runA = headA;
        ListNode runB = headB;
        while(runA!=null){
            runA = runA.next;
            lengthA++;
        }
        while(runB!=null){
            runB = runB.next;
            lengthB++;
        }
        if(lengthA >= lengthB){
            int gap = lengthA-lengthB;
            while(gap > 0){
                headA = headA.next;
                gap--;
            }
        } else{
            int gap = lengthB-lengthA;
            while(gap>0){
                headB = headB.next;
                gap--;
            }
        }
        while(headA!=null && headB!=null){
            if(headA.val == headB.val) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}