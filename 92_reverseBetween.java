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
    //step3: solve this problem using previous one.
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1){
            return reverseN(head, right); //Be attention this is right!
        }
        head.next = reverseBetween(head.next, left-1, right-1); //both minus one!!!!
        return head;
    }
    
    //Step1: how to reverse a linkedlist
    public ListNode reverse(ListNode head){
        if(head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    
    //Step2: how to reverse likedlist's first n character
    ListNode successor = null;
    public ListNode reverseN(ListNode head, int n){
        if(n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
    
}