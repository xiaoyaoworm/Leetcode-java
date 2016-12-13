/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while(curr!=null && count!=k){// dont forget count!= k
            curr = curr.next;
            count++;
        }
        if(count == k){
            curr = reverseKGroup(curr, k);
            
            while(count >0){
                ListNode next = head.next;
                head.next = curr; // connect later
                curr = head; //move two pointers
                head = next;
                count--;
            }
            head = curr; // set new head!!!!
        }
        return head;
    }
}