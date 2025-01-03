fun mincostTickets(days: IntArray, costs: IntArray): Int {
	val dp = IntArray(366)
	val set = days.toSet()
	for (i in 1..365) {
		if (i !in set) {
			dp[i] = dp[i - 1]
		} else {
			dp[i] = minOf(
				dp[i - 1] + costs[0],
				dp[maxOf(0, i - 7)] + costs[1],
				dp[maxOf(0, i - 30)] + costs[2]
			)
		}
	}
	return dp[365]
}

fun main() {
	println(mincostTickets(intArrayOf(1,4,6,7,8,20), intArrayOf(2,7,15)))
	println(mincostTickets(intArrayOf(1,2,3,4,5,6,7,8,9,10,30,31), intArrayOf(2,7,15)))
}