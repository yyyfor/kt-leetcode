import kotlin.math.max

fun takeCharacters(s: String, k: Int): Int {
	val window = IntArray(3)
	for (ch in s) {
		window[ch - 'a']++
	}
	for (c in window) {
		if (c < k) {
			return - 1
		}
	}
	var max = 0
	val count = IntArray(3)
	var left = 0
	for (right in s.indices) {
		count[s[right] - 'a']++
		while (left <= right && (window[0] - count[0] < k || window[1] - count[1] < k || window[2] - count[2] < k)) {
			count[s[left++] - 'a']--
		}
		max = max(max, right - left + 1)
	}
	return s.length - max
}

fun main() {
	println(takeCharacters("aabaaaacaabc", 2))
}