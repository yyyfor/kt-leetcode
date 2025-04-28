fun videoStitching(clips: Array<IntArray>, time: Int): Int {
	clips.sortBy { it[0] }
	var count = 0
	var index = 0
	var max = 0
	while (max < time) {
		var temp = max
		while (index < clips.size && clips[index][0] <= max) {
			temp = maxOf(temp, clips[index][1])
			index++
		}
		if (temp == max) {
			return -1
		}
		max = temp
		count++
	}
	return count
}