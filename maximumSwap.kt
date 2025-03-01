fun maximumSwap(num: Int): Int {
	for (i in 0..< num.toString().length) {
		val res = swap(num.toString(), i)
		if (res != num.toString()) {
			return res.toInt()
		}
	}
	return num
}

fun swap(num: String, index: Int):String {
	var max = num[index]
	var maxIndex = index
	for (i in index + 1..< num.length) {
		if (num[i] >= max) {
			max = num[i]
			maxIndex = i
		}
	}
	return if (max == num[index]) {
		num
	} else {
		num.substring(0, index) + max + num.substring(index + 1, maxIndex) + num[index] + num.substring(maxIndex + 1)
	}
}

fun main() {
	println(maximumSwap(98368))
	println(maximumSwap(2736))
	println(maximumSwap(9973))
}