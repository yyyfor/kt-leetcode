fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
	var dummy = ListNode(-1)
	var carry = 0
	val head = dummy
	var l3 = l1
	var l4 = l2
	while(l3!= null || l4!= null || carry != 0) {
		var sum = 0
		if(l3!= null) {
			sum += l3.`val`
			l3 = l3.next
		}
		if(l4!= null) {
			sum += l4.`val`
			l4 = l4.next
		}
		sum += carry
		carry = sum / 10
		sum %= 10
		dummy.next = ListNode(sum)
		dummy = dummy.next!!
	}
	return head.next
}