import kotlin.math.max
import kotlin.math.min

fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
	nums.sort()
	var left = 0
	var max = 0
	val map = mutableMapOf<Int,Int>()
	for(num in nums) {
		map[num] = map.getOrDefault(num, 0) + 1
	}
	// print(map)
	val l = nums.size
	var right = 0
	for(value in nums[0] .. nums[l - 1]) {
		while(value - nums[left] > k) {
			left++
		}
		while(right < l && nums[right] - value <= k) {
			right++
		}
		val window = right - left
		val maxBound = numOperations + map.getOrDefault(value, 0)
		val freq = min(window, maxBound)
		max = max(max,freq)
	}
	return max
}

/**
 * https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-i/?envType=daily-question&envId=2025-10-21
 * time complexity: O(n log n)
 * space complexity: O(n)
 */