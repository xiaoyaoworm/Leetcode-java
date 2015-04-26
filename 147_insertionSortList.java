//http://xiaoyaoworm.com/blog/2015/04/09/%E6%96%B0leetcode-sort-6-insertion-sort-list/

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
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode run = newHead;
        while(head!=null){
            run = newHead;
            while(run!=null){
                if(run.next == null){
                    run.next = new ListNode(head.val);
                    break;
                } else if(head.val < run.next.val){
                    ListNode temp = run.next;
                    run.next = new ListNode(head.val);
                    run.next.next = temp;
                    break;
                }
                run = run.next;
            }
            head = head.next;
        }
        return newHead.next;
    }
}