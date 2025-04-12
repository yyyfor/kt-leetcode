import java.util.*
import kotlin.math.min

class CustomStack(maxSize: Int) {

	val list = LinkedList<Int>()
	val size = maxSize

	fun push(x: Int) {
		if (list.size < size) {
			list.add(x)
		}
	}

	fun pop(): Int {
		if (list.size == 0) {
			return -1
		}
		return list.removeLast()
	}

	fun increment(k: Int, `val`: Int) {
		for (i in 0 until min(k, list.size)) {
			list[i] = `val` + list[i]
		}
	}

}

/**
 * Your CustomStack object will be instantiated and called as such:
 * var obj = CustomStack(maxSize)
 * obj.push(x)
 * var param_2 = obj.pop()
 * obj.increment(k,`val`)
 */