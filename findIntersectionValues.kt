fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray {
	val set1 = nums1.toSet()
	val set2 = nums2.toSet()
	val intersection = set1.intersect(set2)
	val num1 = set1.count { it in intersection }
	val num2 = set2.count { it in intersection }
	return intArrayOf(num1, num2)
}