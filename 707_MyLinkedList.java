public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}

class MyLinkedList {

    int size;
    ListNode head;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode run = head;
        while(run!= null && index >= 0){
            run = run.next;
            if(index == 0 && run != null) return run.val;
            index --;
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode second = head.next;
        head.next = new ListNode(val);
        head.next.next = second;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode run = head;
        while(run.next != null){
            run = run.next;
        }
        run.next = new ListNode(val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode run = head;
        while(run!= null && index >= 0){
            if(index == 0) {
                ListNode temp = run.next;
                run.next = new ListNode(val);
                run.next.next = temp;
                break;
            }
            run = run.next;
            index --;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode run = head;
        while(run!= null && index >= 0){
            if(index == 0) {
                ListNode temp = run.next;
                if(run.next != null) {
                    run.next = run.next.next;
                    break;
                }
            }
            run = run.next;
            index --;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */