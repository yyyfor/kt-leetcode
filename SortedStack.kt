import java.util.*

class SortedStack() {

	val s1 = Stack<Int>()
	val s2 = Stack<Int>()

	fun push(`val`: Int) {
		if(s1.isEmpty() || `val` <= s1.peek()) {
			s1.push(`val`)
			return
		}
		if(`val` > s1.peek()) {
			while(!s1.isEmpty() && s1.peek() < `val`) {
				s2.push(s1.pop())
			}
			s1.push(`val`)
			while(!s2.isEmpty()) {
				s1.push(s2.pop())
			}
		}
	}

	fun pop() {
		if(!s1.isEmpty()) {
			s1.pop()
		}
	}

	fun peek(): Int {
		if(s1.isEmpty()) {
			return -1
		}
		return s1.peek()
	}

	fun isEmpty(): Boolean {
		return s1.isEmpty()
	}

}

/**
 * Your SortedStack object will be instantiated and called as such:
 * var obj = SortedStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.isEmpty()
 */