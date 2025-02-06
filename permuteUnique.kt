fun permuteUnique(nums: IntArray): List<List<Int>> {
	val result = mutableListOf<List<Int>>()
	val list = mutableListOf<Int>()
	val visited = BooleanArray(nums.size)
	nums.sort()
	dfs(nums, result, 0, list, visited)
	return result
}

fun dfs(nums: IntArray, result: MutableList<List<Int>>,
        index: Int, list: MutableList<Int>,
		visited: BooleanArray) {
	if (index == nums.size) {
		result.add(list.toList())
		return
	}
	for (i in nums.indices) {
		if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])) {
			continue
		}
		visited[i] = true
		list.add(nums[i])
		dfs(nums, result, index + 1, list, visited)
		list.removeAt(list.size - 1)
		visited[i] = false
	}

}

fun main() {
	println(permuteUnique(intArrayOf(1, 1, 2)))
}