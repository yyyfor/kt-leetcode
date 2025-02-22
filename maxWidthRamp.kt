import java.util.Stack

fun maxWidthRamp(nums: IntArray): Int {
	val stack = Stack<Pair<Int, Int>>()
	var max = 0
	for ((key, value) in nums.withIndex()) {
		if (stack.isEmpty() || stack.peek().second > value) {
			stack.push(Pair(key, value))
			continue
		}
		val stack2 = Stack<Pair<Int, Int>>()
		while (stack.isNotEmpty() && stack.peek().second <= value) {
			max = maxOf(max, key - stack.peek().first)
			stack2.push(stack.pop())
		}

		while (stack2.isNotEmpty()) {
			stack.push(stack2.pop())
		}
	}
	return max
}