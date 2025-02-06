fun tupleSameProduct(nums: IntArray): Int {
	var count = 0
	val map = mutableMapOf<Int, Int>()
	for (i in nums.indices) {
		for (j in i + 1 until nums.size) {
			count += map.getOrDefault(nums[i] * nums[j], 0)
			map[nums[i] * nums[j]] = map.getOrDefault(nums[i] * nums[j], 0) + 1
		}
	}
	return count * 8
}