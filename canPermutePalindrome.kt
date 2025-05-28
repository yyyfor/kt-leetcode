fun canPermutePalindrome(s: String): Boolean {
	val map = mutableMapOf<Char,Int>()
	for (ch in s) {
		map[ch] = map.getOrDefault(ch, 0) + 1
	}
	val count = map.values.count { it % 2 == 1 }
	return count <= 1
}