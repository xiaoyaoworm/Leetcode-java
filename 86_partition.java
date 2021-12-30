/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode fakeSmallHead = new ListNode(0);
        ListNode fakeBigHead = new ListNode(0);
        ListNode smallRun = fakeSmallHead;
        ListNode bigRun = fakeBigHead;
        
        while(head!= null){
            if(head.val >= x){
                bigRun.next = new ListNode(head.val);
                bigRun = bigRun.next;
            } else{
                smallRun.next = new ListNode(head.val);
                smallRun = smallRun.next;
            }
            head = head.next;
        }
        
        smallRun.next = fakeBigHead.next;
        bigRun.next = null;
        return fakeSmallHead.next;
    }
}