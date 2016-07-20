/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode run = head;
        while(run!=null){
            RandomListNode newRun = new RandomListNode(run.label);
            newRun.next = run;
            map.put(run, newRun);
            run = run.next;
        }
        
        run = head;
        while(run!=null){
            RandomListNode newRun = map.get(run);
            newRun.random = map.get(newRun.next.random);
            newRun.next = map.get(newRun.next.next);
            run = run.next;
        }

        return map.get(head);
    }
}