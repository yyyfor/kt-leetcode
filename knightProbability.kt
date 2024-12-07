fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
	val dirs = arrayOf(
		intArrayOf(-2, -1),
		intArrayOf(-2, 1),
		intArrayOf(2, -1),
		intArrayOf(2, 1),
		intArrayOf(-1, -2),
		intArrayOf(-1, 2),
		intArrayOf(1, -2),
		intArrayOf(1, 2)
	)

	val dp = Array(k + 1) { Array(n) { DoubleArray(n) } }
	for (step in 0..k) {
		for (i in 0 until n) {
			for (j in 0 until n) {
				if (step == 0) {
					dp[step][i][j] = 1.0
				} else {
					for (dir in dirs) {
						val ni = i + dir[0]
						val nj = j + dir[1]
						if (ni in 0 until n && nj in 0 until n) {
							dp[step][i][j] += dp[step - 1][ni][nj] / 8
						}
					}
				}
			}
		}
	}
	return dp[k][row][column]
}

fun main() {
	println(knightProbability(3,2,0,0))
	println(knightProbability(1,0,0,0))
}