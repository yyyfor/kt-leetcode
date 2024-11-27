import java.util.LinkedList

fun main() {
	val r1 = shortestDistanceAfterQueries(5, arrayOf(intArrayOf(2,4), intArrayOf(0,2), intArrayOf(0,4)))
	val r2 = shortestDistanceAfterQueries(4, arrayOf(intArrayOf(0,3), intArrayOf(0,2)))
	println(r1.joinToString())
	println(r2.joinToString())
}

fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
	val map = mutableMapOf<Int, MutableList<Int>>()
	for(i in 0 until n) {
		map[i] = mutableListOf(i + 1)
	}
	val result = IntArray(queries.size)
	for((index, query) in queries.withIndex()) {
		map[query[0]]!!.add(query[1])
		result[index] = short(map, n)
	}
	return result
}

fun short(map: MutableMap<Int, MutableList<Int>>, n: Int):Int {
	val list = LinkedList<Int>()
	list.add(0)
	val visited = mutableSetOf<Int>()
	var count = 0
	while (list.isNotEmpty()) {
		val size = list.size
		for(i in 0 until size) {
			val node = list.poll()
			if (node == n - 1) {
				return count
			}
			if(visited.contains(node)) {
				continue
			}
			visited.add(node)
			list.addAll(map[node]!!)
		}
		count++
	}
	return count
}