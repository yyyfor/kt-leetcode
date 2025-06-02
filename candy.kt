import kotlin.math.max

fun candy(ratings: IntArray): Int {
	val l = ratings.size
	val dp = IntArray(l) { 1 }
	for (i in 1 until l) {
		if (ratings[i] > ratings[i - 1]) {
			dp[i] = dp[i - 1] + 1
		}
	}
	for (i in l - 1 downTo 0) {
		if (ratings[i] > ratings[i + 1]) {
			dp[i] = max(dp[i], dp[i + 1] + 1)
		}
	}
	return dp.sum()
}