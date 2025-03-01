fun partition(s: String): List<List<String>> {
	val res = mutableListOf<List<String>>()
	helper(s, 0, res, mutableListOf())
	return res
}

fun helper(s: String, i: Int, res: MutableList<List<String>>, cur: MutableList<String>) {
	if (i == s.length) {
		res.add(cur.toList())
		return
	}

	for (index in i..< s.length) {
		if (isPalindrome(s.substring(i, index + 1))) {
			cur.add(s.substring(i, index + 1))
			helper(s, index + 1, res, cur)
			cur.removeAt(cur.size - 1)
		}
	}
}

fun isPalindrome(s: String): Boolean {
	var i = 0
	var j = s.length - 1
	while (i < j) {
		if (s[i] != s[j]) {
			return false
		}
		i++
		j--
	}
	return true
}

fun main() {
	println(partition("aab"))
}