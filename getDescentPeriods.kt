fun getDescentPeriods(prices: IntArray): Long {
	var count = 1L
	var cur = 1
	for (i in 1 until prices.size) {
		if(prices[i] == prices[i - 1] - 1) {
			cur++
		} else {
			cur = 1
		}
		count += cur
	}
	return count
}

fun main() {
	println(getDescentPeriods(intArrayOf(5,4,3,2,1)))
	println(getDescentPeriods(intArrayOf(3,2,1,4)))
	println(getDescentPeriods(intArrayOf(8,6,7,7)))
	println(getDescentPeriods(intArrayOf(1)))
}