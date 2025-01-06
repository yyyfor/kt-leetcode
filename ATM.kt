class ATM() {

	var array = IntArray(5)
	private val amounts = intArrayOf(20, 50, 100, 200, 500)

	fun deposit(banknotesCount: IntArray) {
		for (i in 0..4) {
			array[i] += banknotesCount[i]
		}
	}

	fun withdraw(amount: Int): IntArray {
		var total = amount
		val res = array.copyOf()
		val result = IntArray(5)
		for (i in 4 downTo 0) {
			val count = minOf(total / amounts[i], array[i])
			total -= count * amounts[i]
			res[i] -= count
			result[i] = count
			if (total == 0) {
				break
			}
		}
		if (total == 0) {
			array = res
			return result
		} else {
			return intArrayOf(-1)
		}
	}

}

/**
 * Your ATM object will be instantiated and called as such:
 * var obj = ATM()
 * obj.deposit(banknotesCount)
 * var param_2 = obj.withdraw(amount)
 */