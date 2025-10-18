import kotlin.math.max
import kotlin.math.min

fun maxDistinctElements(nums: IntArray, k: Int): Int {
	nums.sort()
	var prev = Int.MIN_VALUE
	var cur = 0
	var count = 0
	for(num in nums) {
		cur = min(num + k, max(prev + 1, num - k))
		print(cur)
		if(cur > prev) {
			count++
			prev = cur
		}
	}
	return count
}