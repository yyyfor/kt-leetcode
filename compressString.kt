fun compressString(S: String): String {
	if(S.isEmpty() || S.length == 1) {
		return S
	}
	val sb = StringBuilder()
	var count = 1
	for (i in 1 until S.length) {
		if (S[i] == S[i - 1]) {
			count++
		} else {
			sb.append(S[i - 1])
			sb.append(count)
			count = 1
		}
	}
	sb.append(S.last())
	sb.append(count)
	if (sb.length >= S.length) {
		return S
	}
	return sb.toString()
}