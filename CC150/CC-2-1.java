public ListNode removeDuplicate(ListNode head){
    if(head == null || head.next == null) return head;
    HashSet<Integer> set = new HashSet<Integer>();

    ListNode fakeNode = new ListNode(-1);
    ListNode prev = fakeNode;
    ListNode curr = head;
    prev.next = curr;

    while (curr!=null){
        if(!set.contains(curr.val)){
            set.add(curr.val);
            prev.next = curr;
            prev = curr;
        }
        curr = curr.next;
    }
    prev.next = curr;
    return fakeNode.next;
}

O(N) space and O(N) time


public ListNode removeDuplicate(ListNode head){
	if(head == null || head.next == null) return head;
	ListNode curr = head;
	while(curr!=null){
		ListNode run = curr;
		while(run.next!=null){
			if(run.next.val == curr.val){
				run.next = run.next.next;
			} else{
				run = run.next;
			}
		}
		curr = curr.next;
	}
}

O(1) space and O(N^2) time