fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
	val dp = IntArray(high + 1)
	dp[0] = 1
	for (i in 1 .. high) {
		if (i - zero >= 0) {
			dp[i] += dp[i - zero] % 1000000007
		}
		if (i - one >= 0) {
			dp[i] += dp[i - one] % 1000000007
		}
		dp[i] %= 1000000007
	}
	var sum = 0
	for (i in low .. high) {
		sum += dp[i]
		sum %= 1000000007
	}
	return sum
}

fun main() {
	println(countGoodStrings(500, 500, 5, 2))
}