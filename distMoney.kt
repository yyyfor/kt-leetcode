fun distMoney(money: Int, children: Int): Int {
	if (money < children) {
		return -1
	}
	if (money > 8 * children) {
		return children - 1
	}
	if(children * 8 - 4 == money) {
		return children - 2
	}
	val diff = money - children
	return diff / 7

}