fun countPrefixes(words: Array<String>, s: String): Int {
	var count = 0
	for (word in words) {
		if (isPrefix(word, s)) {
			count++
		}
	}
	return count
}

fun isPrefix(word: String, s: String): Boolean {
	var index = 0
	if (word.length > s.length) {
		return false
	}
	while (index < word.length) {
		if (word[index] != s[index]) return false
		index++
	}
	return true
}