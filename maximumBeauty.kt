import java.util.*

fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
	items.sortWith(compareBy({it[0]}, {it[1]}))
	for (item in items.withIndex()) {
		if (item.index == 0) continue
		items[item.index][1] = maxOf(items[item.index][1], items[item.index - 1][1])
	}
	val map = TreeMap<Int, Int>()
	for (item in items) {
		val price = item[0]
		val beauty = item[1]
		map[price] = maxOf(map.getOrDefault(price, 0), beauty)
	}

	val res = IntArray(queries.size)
	for (query in queries.withIndex()) {
		val price = map.floorKey(query.value)
		if (price != null) {
			res[query.index] = map[price]!!
		}
	}
	return res
}