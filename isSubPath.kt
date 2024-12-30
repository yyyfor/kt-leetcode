fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
	if (isEqual(head, root)) {
		return true
	}
	if(root == null) {
		return false
	}
	return isSubPath(head, root.left) || isSubPath(head, root.right)
}

fun isEqual(head: ListNode?, root: TreeNode?):Boolean {
	if (head == null) {
		return true
	}

	if (root == null) {
		return false
	}
	if(head.`val` != root.`val`) {
		return false
	}
	return isEqual(head.next, root.left) || isEqual(head.next, root.right)
}

 class ListNode(var `val`: Int) {
	 var next: ListNode? = null
 }

