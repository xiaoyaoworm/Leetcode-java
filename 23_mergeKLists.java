Time complexity: log(k)*n


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
         
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
         
        for(ListNode l:lists){
            if(l!=null){
                pq.add(l);
            }
        }
         
        ListNode fakeNode = new ListNode(0);
        ListNode run = fakeNode;
         
        while(!pq.isEmpty()){
            ListNode current = pq.poll();
            run.next = current;
            current = current.next;
            run = run.next;
            if(current!=null){
                pq.add(current);
            }
        }
         
        return fakeNode.next;
    }
}