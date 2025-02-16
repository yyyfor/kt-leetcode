fun maximumSum(nums: IntArray): Int {
	var max = -1
	val map = mutableMapOf<Int, Int>()
	for (num in nums) {
		val d = digit(num)
		if (map.containsKey(d)) {
			max = maxOf(max, map[d]!! + num)
			map[d] = maxOf(map[d]!!, num)
		} else {
			map[d] = num
		}
	}
	return max
}

fun digit(num: Int):Int {
	var count = 0
	var n = num
	while (n > 0) {
		count += n % 10
		n /= 10
	}
	return count
}