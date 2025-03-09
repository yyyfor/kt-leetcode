import java.util.*

fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
	val l = graph.size
	val list = mutableListOf<MutableList<Int>>()
	for (i in 0 until l) {
		list.add(mutableListOf())
	}
	val count = IntArray(l)
	for (i in 0 until l) {
		val g = graph[i]
		for (j in g) {
			list[i].add(j)
			count[i]++
		}
	}
	val safe = mutableListOf<Int>()
	val queue = LinkedList<Int>()
	for (i in 0 until l) {
		if (count[i] == 0) {
			queue.add(i)
		}
	}
	while (queue.isNotEmpty()) {
		val node = queue.poll()
		safe.add(node)
		for (n in list[node]) {
			count[n]--
			if (count[n] == 0) {
				queue.add(n)
			}
		}
	}
	safe.sort()
	return safe
}

fun main() {
	println(eventualSafeNodes(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(5), intArrayOf(0), intArrayOf(5), intArrayOf(), intArrayOf())))
}