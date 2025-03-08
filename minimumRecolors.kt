fun minimumRecolors(blocks: String, k: Int): Int {
	var left = 0
	var right = 0
	var count = 0
	while (right < k) {
		if (blocks[right] == 'W') {
			count++
		}
		right++
	}
	var min = count
	while (right < blocks.length) {
		if (blocks[right] == 'W') {
			count++
		}
		if (blocks[left] == 'W') {
			count--
		}
		left++
		right++
		min = minOf(min, count)
	}
	return min
}