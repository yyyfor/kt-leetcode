fun countPrefixSuffixPairs(words: Array<String>): Int {
	var count = 0
	for (i in 0 until words.size - 1) {
		for (j in i + 1 until words.size) {
			if ( words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
				count++
			}
		}
	}
	return count
}