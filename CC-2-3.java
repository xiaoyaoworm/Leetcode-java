public void removeMid(ListNode mid){
	if(mid == null) return;
	if(mid.next == null) return null;
	mid.val = mid.next.val;
	mid.next = mid.next.next;
}