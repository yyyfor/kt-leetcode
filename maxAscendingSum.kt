fun maxAscendingSum(nums: IntArray): Int {
	var max = nums[0]
	var current = 0
	var prev = -1
	for (num in nums) {
		if (prev == -1) {
			prev = num
			current = num
			continue
		}
		if (num > prev) {
			current += num
			prev = num
			max = maxOf(max, current)
		} else {
			prev = num
			current = num
		}
	}
	return max
}