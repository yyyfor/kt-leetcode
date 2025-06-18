fun partition(head: ListNode?, x: Int): ListNode? {
	var l1 = ListNode(-1)
	var l2 = ListNode(-1)
	val l3 = l1
	val l4 = l2
	var h = head
	while(h != null) {
		if(h.`val` < x) {
			l1.next = ListNode(h.`val`)
			l1 = l1.next!!
		} else {
			l2.next = ListNode(h.`val`)
			l2 = l2.next!!
		}
		h = h.next
	}
	l1.next = l4.next
	return l3.next
}