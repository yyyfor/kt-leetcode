fun minimumSize(nums: IntArray, maxOperations: Int): Int {
	var start = 1
	var end = nums.max()
	while (start <= end) {
		val guess = start + (end - start) / 2
		if (choose(nums, maxOperations, guess)) {
			end = guess - 1
		} else {
			start = guess + 1
		}
//		println("start $start")
//		println("end $end")
	}
	return start
}

fun choose(nums: IntArray, maxOperations: Int, guess: Int):Boolean {
	var count = 0
	for (num in nums) {
		count += if (num < guess) 0 else if(num % guess == 0) num / guess - 1 else num / guess
		if (count > maxOperations) {
			return false
		}
	}
	return true
}

fun main() {
	val n1 = minimumSize(intArrayOf(9), 2)
	val n2 = minimumSize(intArrayOf(2,4,8,2), 4)
	val n3 = minimumSize(intArrayOf(7,17), 2)
	println(n1)
	println(n2)
	println(n3)
}