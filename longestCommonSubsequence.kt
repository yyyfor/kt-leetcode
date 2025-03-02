fun longestCommonSubsequence(text1: String, text2: String): Int {
	val l1 = text1.length
	val l2 = text2.length
	val dp = Array(l1 + 1) {IntArray(l2 + 1)}
	for (i in 0..<l1) {
		for (j in 0..<l2) {
			if (text1[i] == text2[j]) {
				dp[i + 1][j + 1] = dp[i][j] + 1
			} else {
				dp[i + 1][j + 1] = dp[i][j + 1].coerceAtLeast(dp[i + 1][j])
			}
		}
	}
	return dp[l1][l2]
}