import kotlin.math.max

class LongestSquareStreakInAnArray {
	fun longestSquareStreak(nums: IntArray): Int {
		nums.sort()
		val map = mutableMapOf<Int,Int>()
		for(num in nums) {
			map[num] = 1
		}
		var max = -1
		for(num in nums) {
			if(num > 1000) continue
			if(map.contains(num * num)) {
				map[num * num] = map[num]!! + 1
				max = max(max, map[num * num]!!)
			}
		}
		return max
	}
}