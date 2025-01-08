fun largestGoodInteger(num: String): String {
	var s = ""
	for(i in 0 until num.length - 2) {
		if(num[i] == num[i + 1] && num[i + 1] == num[i + 2]) {
			s = maxOf(s, num.substring(i, i + 3))
		}
	}
	return s
}