fun partitionArray(nums: IntArray?, k: Int): Int {
	var count = 0
	if (nums == null || nums.isEmpty()) {
		return 0
	}
	nums.sort()
	var index = 0
	while (index < nums.size) {
		var start = index
		while(start < nums.size && nums[start] - nums[index] <= k) {
			start++
		}
		count++
		index = start
	}
	return count
}