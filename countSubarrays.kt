fun countSubarrays(nums: IntArray): Int {
	var count = 0
	val l = nums.size
	for(i in 0 until l - 2) {
		if((nums[i] + nums[i + 2]) * 2 == nums[i + 1]) {
			count++
		}
	}
	return count
}
