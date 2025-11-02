fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
	val dp = Array(m) { IntArray(n) }
	for(guard in guards) {
		dp[guard[0]][guard[1]] = 1
	}
	for(wall in walls) {
		dp[wall[0]][wall[1]] = 2
	}
	for(i in 0 until m) {
		for(j in 0 until n) {
			if(dp[i][j] == 1) {
				mark(i , j, dp, m, n)
			}
		}
	}

	return dp.sumOf { row -> row.count { it == 0 } }
}

fun mark(m: Int, n: Int, dp: Array<IntArray>, row: Int, col: Int) {
	// loop four direction to check if dp[m][n] == 1 or dp[m][n] == 2
	for(i in m - 1 downTo 0) {
		if(dp[i][n] == 1 || dp[i][n] == 2) {
			break
		}
		dp[i][n] = 3
	}

	for(i in m + 1 until row) {
		if(dp[i][n] == 1 || dp[i][n] == 2) {
			break
		}
		dp[i][n] = 3
	}

	for(j in n - 1 downTo 0) {
		if(dp[m][j] == 1 || dp[m][j] == 2) {
			break
		}
		dp[m][j] = 3
	}

	for(j in n + 1 until col) {
		if (dp[m][j] == 1 || dp[m][j] == 2) {
			break
		}
		dp[m][j] = 3
	}
}
