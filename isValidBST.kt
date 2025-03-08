import java.util.LinkedList

fun isValidBST(root: TreeNode?): Boolean {
	var node = root
	val list = LinkedList<TreeNode>()
	while (node != null) {
		list.add(node)
		node = node.left
	}
	var max = Long.MIN_VALUE
	while (list.isNotEmpty()) {
		node = list.removeLast()
		if (node.`val` <= max) {
			return false
		}
		max = node.`val`.toLong()
		if (node.right != null) {
			var right = node.right
			while (right != null) {
				list.add(right)
				right = right.left
			}
		}
	}
	return true
}