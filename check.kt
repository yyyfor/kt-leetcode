fun check(nums: IntArray): Boolean {
	var bigCount = 0
	for(i in 0 until nums.size - 1) {
		if(nums[i] > nums[i + 1]) {
			bigCount++
			if (bigCount > 1) {
				return false
			}
		}
	}
	if(bigCount == 0) {
		return true
	}
	if(nums[0] >= nums[nums.size - 1]) {
		return true
	}
	return false
}