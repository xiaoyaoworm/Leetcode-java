/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        Stack<ListNode> stack = new Stack<ListNode>();
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode run = fakeHead;
        while(!stack.isEmpty()){
            run.next = stack.pop();
            run = run.next;
        }
        run.next = null; // do not forget this!!! otherwise it will become a circle
        return fakeHead.next;
    }
}