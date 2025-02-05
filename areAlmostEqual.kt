fun areAlmostEqual(s1: String, s2: String): Boolean {
	if (s1 == s2) {
		return true
	}
	if (s1.length != s2.length) {
		return false
	}
	var count = 0
	val array = IntArray(26)
	for (i in s1.indices) {
		if (s1[i]!= s2[i]) {
			count++
			if (count > 2) {
				return false
			}
			array[s1[i] - 'a']++
			array[s2[i] - 'a']--
		}
	}
	for (i in array) {
		if(i != 0) {
			return false
		}
	}
	return count == 0 || count == 2
}