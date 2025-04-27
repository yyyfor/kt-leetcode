fun minimumTime(time: IntArray, totalTrips: Int): Long {
	var left = 1L
	var right = time.max().toLong() * totalTrips
	while (left < right) {
		val mid = left + (right - left) / 2
		if (calculateTotal(time, totalTrips, mid)) {
			right = mid
		} else {
			left = mid + 1
		}
	}
	return left
}

fun calculateTotal(time: IntArray, totalTrips: Int, guess: Long): Boolean {
	var count = 0L
	for (t in time) {
		count += guess / t
		if (count >= totalTrips) {
			return true
		}
	}
	return false
}