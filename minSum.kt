import kotlin.math.max

fun minSum(nums1: IntArray, nums2: IntArray): Long {
	var leftSum = 0L
	var rightSum = 0L
	var leftZ = 0
	var rightZ = 0
	for (num in nums1) {
		if (num == 0) {
			leftZ++
		}
		leftSum += num
	}
	for (num in nums2) {
		if (num == 0) {
			rightZ++
		}
		rightSum += num
	}
	// println(leftSum)
	// println(rightSum)
	val left = leftSum + leftZ
	val right = rightSum + rightZ

	if((leftZ == 0 && left < right) || (rightZ == 0 && left > right)) {
		return -1
	}
	return max(left, right)
}