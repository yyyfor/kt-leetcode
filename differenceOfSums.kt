fun differenceOfSums(n: Int, m: Int): Int {
	var sum1 = 0
	var sum2 = 0
	for (i in 1..n) {
		if (i % m == 0) {
			sum2 += i
		} else {
			sum1 += i
		}
	}
	return sum1 - sum2
}