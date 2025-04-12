fun maxProfit(prices: IntArray): Int {
	var profit = 0
	var prev = prices[0]
	for (i in 1 until prices.size) {
		if (prices[i] > prev) {
			profit += prices[i] - prev
		}
		prev = prices[i]
	}
	return profit
}