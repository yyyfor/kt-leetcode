fun smallestNumber(n: Int): Int {
	if(n == 1) return 1
	var sum = 1
	while(sum < n) {
		sum *= 2
	}
	if(sum == n) {
		return 2 * sum - 1
	}
	return sum - 1
}