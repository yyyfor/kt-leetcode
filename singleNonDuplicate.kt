fun singleNonDuplicate(nums: IntArray): Int {
	var left = 0
	var right = nums.size - 1
	while (left < right) {
		val mid = left + (right - left) / 2
		if (mid % 2 == 0) {
			if (nums[mid] == nums[mid + 1]) {
				left = mid + 2
			} else {
				right = mid
			}
		} else {
			if (nums[mid] == nums[mid - 1]) {
				left = mid + 1
			} else {
				right = mid
			}
		}
	}
	return nums[left]
}

fun main() {
	println(singleNonDuplicate(intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)))
	println(singleNonDuplicate(intArrayOf(3, 3, 7, 7, 10, 11, 11)))
}