import java.util.*

fun maxEvents(events: Array<IntArray>): Int {
	events.sortBy { it[0] }
	val queue = PriorityQueue<Int>()
	var start = 1
	var count = 0
	var i = 0
	while (i < events.size || !queue.isEmpty()) {
		while (i < events.size && events[i][0] == start) {
			queue.offer(events[i][1])
			i++
		}

		while (!queue.isEmpty() && queue.peek() < start) {
			queue.poll()
		}

		if (!queue.isEmpty()) {
			queue.poll()
			count++
		}
		start++
	}
	return count
}

fun main() {
	println(maxEvents(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4))))
	println(maxEvents(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(1,2))))
}