fun similarPairs(words: Array<String>): Int {
	val list = mutableListOf<Set<Char>>()
	for (word in words) {
		list.add(word.toSet())
	}
	var count = 0
	for(i in list.indices) {
		for(j in i+1 until list.size) {
			if(list[i] == list[j]) {
				count++
			}
		}
	}
	return count
}