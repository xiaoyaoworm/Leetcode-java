public ListNode partition(ListNode head, int value){
    ListNode fakeFirst = new ListNode(-1);
    ListNode fakeSecond = new ListNode(-1);
    ListNode run1 = fakeFirst;
    ListNode run2 = fakeSecond;
    while(head!=null){
        if(head.val >= value){
            run2.next = head;
            run2 = run2.next;
        } else{
            run1.next = head;
            run1 = run1.next;
        }
        head = head.next;
    }
    run2.next = null;
    run1.next = fakeSecond.next;
    return fakeFirst.next;
}