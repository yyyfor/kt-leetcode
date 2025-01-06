fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
	val l = s.length
	val dp = IntArray(l + 1)
	for (shift in shifts) {
		if (shift[2] == 1) {
			dp[shift[0]] += 1
			dp[shift[1] + 1] -= 1
		} else {
			dp[shift[0]] -= 1
			dp[shift[1] + 1] += 1
		}
	}
	val chars = s.toCharArray()
	for (i in 0 until l) {
		dp[i + 1] += dp[i]
		if (dp[i] > 0) {
			chars[i] = 'a' + (chars[i] - 'a' + dp[i]) % 26
		} else {
			chars[i] = 'z' - ('z' - chars[i] - dp[i]) % 26
		}
	}
	return String(chars)
}

fun main() {
	println(shiftingLetters("abc", arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 2, 1), intArrayOf(0,2,1))))
}