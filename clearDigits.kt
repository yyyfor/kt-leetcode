import java.util.*

fun clearDigits(s: String): String {
	val stack = Stack<Char>()
	for (ch in s) {
		if (ch.isDigit() && stack.isNotEmpty()) {
			stack.pop()
		}
		if (ch.isLetter()) {
			stack.push(ch)
		}
	}
	var result = ""
	while (stack.isNotEmpty()) {
		result = stack.pop() + result
	}
	return result
}

fun main() {
	println(clearDigits("abc"))
	println(clearDigits("cb34"))
}