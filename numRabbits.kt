fun numRabbits(answers: IntArray): Int {
	var count = 0
	val map = mutableMapOf<Int, Int>()
	for (answer in answers) {
		map[answer] = map.getOrDefault(answer, 0) + 1
		if (map[answer]!! == 1) {
			count += answer + 1
		}
		if (map[answer]!! % (answer + 1) == 0) {
			map[answer] = 0
		}
	}
	return count
}