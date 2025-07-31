import java.util.*

class TripleInOne(stackSize: Int) {
	val map = mutableMapOf<Int, Stack<Int>>()
	val size = stackSize

	fun push(stackNum: Int, value: Int) {
		if(!map.containsKey(stackNum) && size != 0) {
			map[stackNum] = Stack<Int>()
			map[stackNum]!!.push(value)
		} else if (map.containsKey(stackNum) && map[stackNum]!!.size != size) {
			map[stackNum]!!.push(value)
		}
	}

	fun pop(stackNum: Int): Int {
		return if(map.containsKey(stackNum) && map[stackNum]!!.size!= 0) {
			map[stackNum]!!.pop()
		} else {
			-1
		}
	}

	fun peek(stackNum: Int): Int {
		return if(map.containsKey(stackNum) && map[stackNum]!!.size!= 0) {
			map[stackNum]!!.peek()
		} else {
			-1
		}
	}

	fun isEmpty(stackNum: Int): Boolean {
		return if(map.containsKey(stackNum)) {
			map[stackNum]!!.isEmpty()
		} else {
			true
		}
	}
}
/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */