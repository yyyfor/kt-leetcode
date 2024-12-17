fun repeatLimitedString(s: String, repeatLimit: Int): String {
	val sb = StringBuilder()
	val array = s.toCharArray()
	array.sortDescending()
	val str = String(array)
//	println(str)
	var i = 0
	while (i < str.length) {
		val pair = generate(str, repeatLimit, i)
		sb.append(pair.first)
		i = pair.second
	}
	return sb.toString()
}

fun generate(s: String, repeatLimit: Int, index: Int): Pair<String, Int> {
	var count = 1
	val sb = StringBuilder()
	var j = index + 1
	while (j < s.length && s[j] == s[index]) {
		j++
	}
	var i = index
	while (i < s.length) {
		if (s[i] != s[index]) {
			break
		}
		if (count <= repeatLimit) {
			sb.append(s[i])
			count++
			i++
		} else if (j < s.length) {
			sb.append(s[j])
			j++
			count = 1
		} else if(j == s.length) {
			break
		}

	}
//	println(sb.toString())
//	println(j)
	return Pair(sb.toString(), j)
}

fun main() {
//	println(repeatLimitedString("hello", 2))
//	println(repeatLimitedString("LeetcodeHelpsMeLearn", 3))
	println(repeatLimitedString("cczazcc", 3))
	println(repeatLimitedString("aababab", 2))

}