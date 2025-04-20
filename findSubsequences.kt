fun findSubsequences(nums: IntArray): List<List<Int>> {
	val result = mutableListOf<List<Int>>()
	backtrack(nums, mutableListOf(),  Int.MIN_VALUE, 0,  result)
	return result
}

fun backtrack(nums: IntArray, list: MutableList<Int>, last:Int, index: Int, result: MutableList<List<Int>>) {
	if (index == nums.size) {
		if (list.size > 1) {
			result.add(list.toList())
		}
		return
	}

	if (nums[index] >= last) {
		list.add(nums[index])
		backtrack(nums, list, nums[index], index + 1, result)
		list.removeLast()
	}
	if (nums[index] != last) {
		backtrack(nums, list, last, index, result)
	}
}

fun main() {
	println(findSubsequences(intArrayOf(4,6,7,7)))
}

