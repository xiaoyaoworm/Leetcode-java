ListNode nToLast(ListNode head, int k){
	if(k<0) return null;
	ListNode p1 = head;
	ListNode p2 = head;

	int count = 0;
	while(count < k){
		if(p2 == null) return null;
		p2 = p2.next;
		count++;
	}
	if(p2 == null) return null; //Important!!! Be careful not forgetting this!!!

	while(p2.next!=null){ // from last, not the null end
		p1 = p1.next;
		p2 = p2.next;
	}
	return p1;
}

O(N) time and O(1) space                   xx