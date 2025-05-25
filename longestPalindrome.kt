fun longestPalindrome(words: Array<String>): Int {
	var count = 0
	val set = mutableMapOf<Int, Int>()
	val pairSet = mutableSetOf<Int>()
	for (word in words) {
		val key = word[0].code * 26 + word[1].code
		val reverseKey = word[1].code * 26 + word[0].code
		// println(key)
		// println(reverseKey)
		if (set.contains(key) && set[key]!! >= 1 ) {
			count += 4
			set[key] = set[key]!! - 1
			if(set[key] == 0) {
				set.remove(key)
			}
		} else {
			set[reverseKey] = set.getOrDefault(reverseKey, 0) + 1
		}
		if (key == reverseKey) {
			pairSet.add(key)
		}
	}
	val s = set.keys intersect pairSet
	if (s.isNotEmpty()) {
		count += 2
	}
	return count
}