fun main() {
	val colors1 = intArrayOf(0,1,0,1,0)
	println(numberOfAlternatingGroups(colors1, 3))
	val color2 = intArrayOf(0,1,0,0,1,0,1)
	println(numberOfAlternatingGroups(color2, 6))
}

fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
	val n: Int = colors.size
	var res = 0
	var cnt = 1
	for (i in -k + 2 until n) {
		if (colors[(i + n) % n] !== colors[(i - 1 + n) % n]) {
			cnt += 1
		} else {
			cnt = 1
		}
		if (cnt >= k) {
			res += 1
		}
	}
	return res
}