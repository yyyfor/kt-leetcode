fun rotate(matrix: Array<IntArray>): Unit {
	var i = 0
	var j = matrix.size - 1
	while (i < j) {
		for (k in matrix.indices) {
			val tmp = matrix[i][k]
			matrix[i][k] = matrix[j][k]
			matrix[j][k] = tmp
		}
		i++
		j--
	}
	i = 0
	j = 0
	while (i < matrix.size) {
		while(j < i) {
			val tmp = matrix[i][j]
			matrix[i][j] = matrix[j][i]
			matrix[j][i] = tmp
			j++
		}
		i++
		j = 0
	}
}