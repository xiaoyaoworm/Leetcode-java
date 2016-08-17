双指针 不用reverse的情况：

public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode fake = new ListNode(0); // put fake head in the beginning
        fake.next = head;
        
        boolean fakeHead = false; // fake head will be new header or not.
        
        ListNode p = fake;
        ListNode q = head;
        while(q!=null){
            if(q.val != 9) p = q; //find the first non-9 to be p
            q = q.next;
        }
        
        if(p == fake) fakeHead = true; 
        //find p is still in the fake position, then fake will be the new head
        
        while(p!=null){
            if(p.val != 9) 
                p.val++; //change the first non-9(if fakeHead == true, this is fakeHead's 0) to be ++ number
            else p.val = 0; // change the rest 9 to 0.
            p = p.next;
        }
        
        if(fakeHead) return fake; // fakeHead is new head
        else return head; // head is still head
    }
}




两次reverse的解法：

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        int carry = 1;
        head = reverse(head); 
        ListNode run = head;
        
        while(run!=null){
            int sum = run.val+carry;
            run.val = sum%10;
            carry = sum/10;
            if(carry == 0) return reverse(head);
            if(run.next == null){
                run.next = new ListNode(1);
                return reverse(head);
            }
            run = run.next;
        }
        return null;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode p = head;
        ListNode q = head.next;
        
        head.next = null;
        while(p!=null && q!=null){
            ListNode next = q.next;
            q.next = p;
            p = q;
            if(next!=null) q = next;
            else break;
        }
        return q;
    }
}