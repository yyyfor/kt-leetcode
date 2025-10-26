class Bank(balance: LongArray) {
	private val b = LongArray(balance.size + 1)
	init {
		for( (index, value) in balance.withIndex()) {
			b[index + 1] = value
		}
	}

	fun transfer(account1: Int, account2: Int, money: Long): Boolean {
		if(account1 > b.size || account2 > b.size) {
			return false
		}
		if(b[account1] >= money) {
			b[account1] -= money
			b[account2] += money
			return true
		}
		return false
	}

	fun deposit(account: Int, money: Long): Boolean {
		if(account > b.size) {
			return false
		}
		b[account] += money
		return true
	}

	fun withdraw(account: Int, money: Long): Boolean {
		if (account < b.size && b[account] >= money) {
			b[account] -= money
			return true
		}
		return false
	}

}

/**
 * Your Bank object will be instantiated and called as such:
 * var obj = Bank(balance)
 * var param_1 = obj.transfer(account1,account2,money)
 * var param_2 = obj.deposit(account,money)
 * var param_3 = obj.withdraw(account,money)
 */