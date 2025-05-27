fun isUnique(astr: String): Boolean {
	var num = 1
	for (ch in astr) {
		val index = ch - 'a'
		if ((num and (1 shl index)) != 0) {
			return false
		}
		num = num or (1 shl index)
	}
	return true
}