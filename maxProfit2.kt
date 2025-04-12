fun maxProfit2(prices: IntArray): Int {
	var min1 = Int.MAX_VALUE
	var min2 = Int.MAX_VALUE
	var diff1 = 0
	var diff2 = 0
	for (price in prices) {
		if (price < min1) {
			min2 = min1
			min1 = price
		} else if (price < min2) {
			min2 = price
		}
		if (price - min1 > diff1) {
			diff2 = diff2 + min1 - min2
			diff1 = price - min1
		} else if (price - min2 > diff2) {
			diff2 = price - min2
		}
	}
	return diff1 + diff2
}

fun main() {
	println(maxProfit2(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)))
	println(maxProfit2(intArrayOf(1,2,3,4,5)))
	println(maxProfit2(intArrayOf(5,4,3,2,1)))
}