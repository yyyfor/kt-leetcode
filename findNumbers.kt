fun findNumbers(nums: IntArray): Int {
	var count = 0
	for (num in nums) {
		if(calculate(num)) {
			count++
		}
	}
	return count
}

fun calculate(num: Int):Boolean {
	var count = 0
	var n = num
	while (n != 0) {
		n /= 10
		count++
	}
	return count % 2 == 0
}