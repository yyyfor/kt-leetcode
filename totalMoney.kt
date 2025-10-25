fun totalMoney(n: Int): Int {
	var sum = 0
	var base = 1
	for(i in 1 .. n) {
		sum += (i - 1) % 7 + base
		if(i % 7 == 0) {
			base++
		}
	}
	return sum
}