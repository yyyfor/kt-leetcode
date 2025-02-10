fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
	val result = mutableListOf<IntArray>()
	var end = false
	for (interval in intervals) {
		if (interval[1] < newInterval[0] || end) {
			result.add(interval)
			continue
		}
		if (interval[0] > newInterval[1]) {
			result.add(newInterval)
			result.add(interval)
			end = true
			continue
		}
		newInterval[0] = minOf(newInterval[0], interval[0])
		newInterval[1] = maxOf(newInterval[1], interval[1])
	}
	if (!end) {
		result.add(newInterval)
	}
	return result.toTypedArray()
}

fun main() {
	val r = insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5))
	for (i in r) {
		println(i.contentToString())
	}
}