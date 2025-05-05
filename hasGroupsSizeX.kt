fun hasGroupsSizeX(deck: IntArray): Boolean {
	val map = hashMapOf<Int, Int>()
	for (num in deck) {
		map[num] = (map[num] ?: 0) + 1
	}
	var prev = -1
	for (value in map.values) {
		if (-1 == prev) {
			prev = value
		}

		prev = gcd(prev, value)
		if (prev == 1) {
			return false
		}
	}
	return true
}

fun gcd(a: Int, b: Int): Int {
	if (b == 0) {
		return a
	}
	return gcd(b, a % b)
}