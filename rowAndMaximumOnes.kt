fun rowAndMaximumOnes(mat: Array<IntArray>): IntArray {
	var max = 0
	var index = 0
	var result = IntArray(0)
	for (row in mat.withIndex()) {
		val count = row.value.count { it == 1 }
		if (count > max) {
			max = count
			index = row.index
		}
	}
	return intArrayOf(index, max)
}