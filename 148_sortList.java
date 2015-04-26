//http://xiaoyaoworm.com/blog/2015/04/03/%E6%96%B0leetcode-sort-1-sort-list/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        int length = 0;
        ListNode p = head;
        while(p!=null){
            length++;
            p = p.next;
        }
         
        int mid = length/2;
        int n = 1; //pay attention, this is not 0!!!!
        ListNode l = head;
        ListNode r = null;
        p = head;
        while(n <= mid){
            if(n == mid){
                r = p.next;
                p.next = null;
                break;
            }
            n++;
            p = p.next;
        }
         
        ListNode sortedL = sortList(l);
        ListNode sortedR = sortList(r);
        return merge(sortedL, sortedR);
    }
     
    public ListNode merge(ListNode p1, ListNode p2){
        ListNode fake = new ListNode(0);
        ListNode result = fake;
        while(p1!=null && p2!=null){
            if(p1.val <= p2.val){
                fake.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                fake.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            fake = fake.next;
        }
        if(p1!=null){
            fake.next = p1;
        }
        if(p2!=null){
            fake.next = p2;
        }
         
        return result.next;
    }
}