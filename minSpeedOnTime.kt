fun main() {
	val array = intArrayOf(5,3,4,6,2,2,7)
	println(minSpeedOnTime(array, 10.92))
}

fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
	var left = 1
	var right = 10000000
	while (left <= right) {
		val mid = left + (right - left) / 2
		if (check(dist, hour, mid)) {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	if(check(dist, hour, left)) {
		return left
	}
	return -1
}

fun check(dist: IntArray, hour: Double, speed: Int): Boolean {
	var time = 0.0
	for(i in 0 until dist.size - 1) {
		time += (dist[i] + speed - 1) / speed
		if (time > hour) {
			return false
		}
	}
	time += dist[dist.size - 1].toDouble() / speed
	return time <= hour
}