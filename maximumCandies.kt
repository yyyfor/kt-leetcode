fun maximumCandies(candies: IntArray, k: Long): Int {
	var left = 0L
	var right = 0L
	for (candy in candies) {
		right += candy
	}
	if (right < k) {
		return 0
	}
	while (left <= right) {
		val mid = left + (right - left) / 2
		if (mid == 0L) {
			return right.toInt()
		}
		if (find(candies, k, mid)) {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return right.toInt()
}


fun find(candies: IntArray, k: Long, size: Long): Boolean {
	var count = 0L
	for (candy in candies) {
		count += candy / size
		if (count >= k) {
			return true
		}
	}
	return false
}