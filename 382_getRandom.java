/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode head;
    HashMap<Integer, Integer> map;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.map = new HashMap<Integer, Integer>();
        this.head = head;
        ListNode run = head;
        int index = 0;
        while(run!=null){
            map.put(index, run.val);
            run = run.next;
            index++;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(map.size());
        return map.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */