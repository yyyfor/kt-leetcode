class OrderedStream(n: Int) {
	val array = Array(n + 1) {""}
	private var ptr = 1

	fun insert(idKey: Int, value: String): List<String> {
		array[idKey] = value
		val res = mutableListOf<String>()
		while (ptr < array.size && array[ptr] != "") {
			res.add(array[ptr])
			ptr++
		}
		return res
	}
}