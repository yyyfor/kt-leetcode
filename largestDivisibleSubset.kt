fun largestDivisibleSubset(nums: IntArray): List<Int> {
	val dp = IntArray(nums.size)
	val prev = IntArray(nums.size) { -1 }
	dp[0] = 0

	nums.sort()
	var max = 0
	var maxIndex = 0
	for (i in 1 until nums.size) {
		for (j in 0 until i) {
			if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
				dp[i] = dp[j] + 1
				prev[i] = j
				if (dp[i] > max) {
					max = dp[i]
					maxIndex = i
					// println(max)
					// println(maxIndex)
				}
			}
		}
	}

	val result = mutableListOf<Int>()
	while (maxIndex != -1) {
		result += nums[maxIndex]
		maxIndex = prev[maxIndex]
	}
	return result.reversed()
}