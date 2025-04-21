import kotlin.math.sqrt

fun repairCars(ranks: IntArray, cars: Int): Long {
	var left = 1L
	var right = ranks.min().toLong() * cars * cars
	while (left < right) {
		val mid = left + (right - left) / 2
		if (search(ranks, cars, mid)) {
			right = mid
		} else {
			left = mid + 1
		}
	}
	return left
}

fun search(ranks: IntArray, cars: Int, num: Long):Boolean {
	var count = 0
	for(rank in ranks) {
		count += sqrt(num.toDouble() / rank).toInt()
		if (count >= cars) {
			return true
		}
	}
	return false
}