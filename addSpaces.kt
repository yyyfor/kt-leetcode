fun addSpaces(s: String, spaces: IntArray): String {
	val sb = StringBuilder()
	var spaceIndex = 0
	for (i in s.indices) {
		if(spaceIndex < spaces.size && i == spaces[spaceIndex]) {
			sb.append(" ")
			spaceIndex++
		}
		sb.append(s[i])
	}
	return sb.toString()
}

fun main() {
	val s1 = addSpaces("hello", intArrayOf(2, 3))
	println(s1)
	val s2 = addSpaces("LeetcodeHelpsMeLearn", intArrayOf(8,13,15))
	println(s2)
}