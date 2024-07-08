fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
	val list = difficulty.zip(profit).sortedBy { it.first }
	var count = 0
	for (w in worker) {
		var max = 0
		for (i in list.indices) {
			if (list[i].first > w) {
				break
			}
			max = maxOf(max, list[i].second)
		}
		count += max
	}
	return count
}