import kotlin.math.max

fun longestSubarray(nums: IntArray): Int {
	var prev = -1
	var count = 0
	var max = 0
	for(num in nums) {
		if(num == 1) {
			count++
		} else {
			if(prev > 0) {
				max = max(max, prev + count)
			}
			prev = count
			count = 0
		}
	}
	max = max(max, prev + count)
	return max
}