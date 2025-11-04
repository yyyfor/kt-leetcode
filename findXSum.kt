fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
	val result = IntArray(nums.size - k + 1)
	for(i in 0 .. nums.size - k) {
		val map = mutableMapOf<Int, Int>()
		for(j in i until i + k) {
			map[nums[j]] = map.getOrDefault(nums[j], 0) + 1
		}
		// print(map)

		val map2 = map.entries.sortedWith(compareByDescending<Map.Entry<Int, Int>> { it.value }.thenByDescending { it.key })
		// print(map2)
		val list = map2.toList()
		for((index, pair) in list.withIndex()) {
			result[i] += if(index < x) pair.key * pair.value else 0
		}

	}
	return result
}