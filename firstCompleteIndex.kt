fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
	val numRows = mat.size
	val numCols = mat[0].size
	val rowCount = IntArray(numRows)
	val colCount = IntArray(numCols)
	val numToPos: MutableMap<Int, IntArray> = HashMap()

	// Create a map to store the position of each number in the matrix
	for (row in 0 until numRows) {
		for (col in 0 until numCols) {
			val value = mat[row][col]
			numToPos[value] = intArrayOf(row, col)
		}
	}

	for (i in arr.indices) {
		val num = arr[i]
		val pos = numToPos[num]
		val row = pos!![0]
		val col = pos[1]

		// Increment the count for the corresponding row and column
		rowCount[row]++
		colCount[col]++

		// Check if the row or column is completely painted
		if (rowCount[row] == numCols || colCount[col] == numRows) {
			return i
		}
	}

	return -1 // This line will never be reached as per the problem statement
}
