import kotlin.math.min

fun minNumber(nums1: IntArray, nums2: IntArray): Int {
	var min = 10
	val set = nums1.toSet()
	for (num in nums2) {
		if(set.contains(num)) {
			min = min(min, num)
		}
	}
	if (min != 10) {
		return min
	}
	val mi1 = nums1.min()
	val mi2 = nums2.min()
	return if(mi1 < mi2) {
		10 * mi1 + mi2
	} else {
		10 * mi2 + mi1
	}
}