fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
	val map = mutableMapOf<Int, Int>()
	val keyMap = mutableMapOf<Int, Int>()
	val result = IntArray(queries.size)
	for (i in queries.indices) {
		val key = queries[i][0]
		val value = queries[i][1]
		if (keyMap.containsKey(key)) {
			val oldValue = keyMap[key]!!
			map[oldValue] = map[oldValue]!!.minus(1)
			if (map[oldValue] == 0) {
				map.remove(oldValue)
			}
		}
		keyMap[key] = value
		map[value] = map.getOrDefault(value, 0).plus(1)
		result[i] = map.keys.size
	}
	return result
}