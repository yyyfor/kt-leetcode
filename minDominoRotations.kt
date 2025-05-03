fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
	val array = Array(7) { IntArray(3) }
	for (i in tops.indices) {
		array[tops[i]][0]++
		array[bottoms[i]][1]++
		if (tops[i] == bottoms[i]) {
			array[tops[i]][2]++
		}
	}
	for (i in array.indices) {
		if (array[i][0] + array[i][1] - array[i][2] == tops.size) {
			return tops.size - maxOf(array[i][0], array[i][1])
		}
	}
	return -1
}