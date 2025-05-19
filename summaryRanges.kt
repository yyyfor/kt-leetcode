fun summaryRanges(nums: IntArray): List<String> {
	var start = 0
	val result = mutableListOf<String>()
	while (start < nums.size) {
		var end = start + 1
		while (end < nums.size && nums[end] - nums[end - 1] == 1) {
			end++
		}
		if (end - start == 1) {
			result.add(nums[start].toString())
		} else {
			result.add("${nums[start]}->${nums[end - 1]}")
		}
		start = end
	}
	return result
}