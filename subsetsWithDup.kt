fun subsetsWithDup(nums: IntArray): List<List<Int>> {
	val result = mutableListOf<List<Int>>()
	val list = mutableListOf<Int>()
	nums.sort()
	helper(nums, 0, list, result)
	return result
}

fun helper(nums: IntArray, index: Int, list: MutableList<Int>, result: MutableList<List<Int>>) {
	if (index > nums.size) {
		return
	}
	result.add(list.toList())
	if (index == nums.size) {
		return
	}
	var i = index
	while (i < nums.size) {
		list.add(nums[i])
		helper(nums, i + 1, list, result)
		list.removeAt(list.size - 1)
		i++
		while (i < nums.size && nums[i] == nums[i - 1]) {
			i++
		}
	}
}

fun main() {
	println(subsetsWithDup(intArrayOf(1, 2, 2)))
}
