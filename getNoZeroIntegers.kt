fun getNoZeroIntegers(n: Int): IntArray {
	for(i in 1 until n / 2 + 1) {
		if(!hasZero(i) && !hasZero(n - i)) {
			return intArrayOf(i, n - i)
		}
	}
	return intArrayOf()
}

fun hasZero(n: Int): Boolean {
    return n.toString().contains('0')
}
