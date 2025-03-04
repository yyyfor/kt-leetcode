fun checkPowersOfThree(n: Int): Boolean {
	val dp = IntArray(n + 1)
	dp[0] = 1
	var i = 1
	var sum = 1
	while (i <= n) {
		for (j in i .. minOf(n, sum)) {
			if(dp[j - i] == 1) {
//				println(j)
				dp[j] = 1
			}
		}
		if (dp[n] == 1) return true
		i *= 3
		sum += i
	}
	return false
}

fun main() {
	println(checkPowersOfThree(12))
	println(checkPowersOfThree(91))
	println(checkPowersOfThree(21))
	println(checkPowersOfThree(37))
}