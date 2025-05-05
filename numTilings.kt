fun numTilings(n: Int): Int {
	val dp = IntArray(n + 1)
	val divider = 1000000007
	for (i in 1..n) {
		if (i == 1) {
			dp[i] = 1
		} else if (i == 2) {
			dp[i] = 2
		} else if (i == 3) {
			dp[i] = 5
		} else {
			dp[i] = ((2L * dp[i - 1] + dp[i - 3]) % divider).toInt()
		}
	}
	return dp[n]
}