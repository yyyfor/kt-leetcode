import java.util.*
import kotlin.math.max


fun maxFrequency(nums: IntArray, k: Int): Int {
	nums.sort()
	var left = 0
	var ans = 0
	var curr: Long = 0

	for (right in nums.indices) {
		val target = nums[right].toLong()
		curr += target

		while ((right - left + 1) * target - curr > k) {
			curr -= nums[left]
			left++
		}

		ans = max(ans, right - left + 1)
	}

	return ans
}
