fun minOperations(boxes: String): IntArray {
	val l = boxes.length
	var right = 0
	var rCount = 0
	var lCount = 0
	var left = 0
	val res = IntArray(l)
	for (i in 0 until l) {
		if (boxes[i] == '1') {
			right += i + 1
			rCount++
		}
	}
	for (i in 0 until l) {
		right -= rCount
		left += lCount
		res[i] = right + left
		if (boxes[i] == '1') {
			rCount--
			lCount++
		}
	}
	return res
}

fun main() {
	println(minOperations("110").joinToString())
	println(minOperations("001011").joinToString())
}