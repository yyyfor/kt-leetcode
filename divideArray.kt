fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
	val result = Array(nums.size / 3) { IntArray(3) }
	nums.sort()
	for(i in nums.indices step 3) {
		if(nums[i + 2] - nums[i] > k) {
			return emptyArray()
		}
		result[i / 3] = intArrayOf(
			nums[i],
			nums[i + 1],
			nums[i + 2]
		)
	}
	return result
}