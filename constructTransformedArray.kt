fun constructTransformedArray(nums: IntArray): IntArray {
	val l = nums.size
	val result = IntArray(l)
	for((index, num) in nums.withIndex()) {
		println(index)
		println(num)

		if (num > 0) {
			val n = num % l
			var pos = n + index
			if (pos >= l) {
				pos -= l
			}
			result[index] = nums[pos]
		} else if(num < 0) {
			val n = (num * -1) % l
			var pos = index - n
			if (pos < 0) {
				pos += l
			}
			result[index] = nums[pos]
		} else {
			result[index] = nums[index]
		}
	}
	return result
}

fun main() {
	println(constructTransformedArray(intArrayOf(3,-2,1,1)).joinToString())
	println(constructTransformedArray(intArrayOf(-1,4,-1)).joinToString())
}