fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
	val list = mutableListOf<IntArray>()
	var i = 0
	var j = 0
	while (i < nums1.size && j < nums2.size) {
		if (nums1[i][0] < nums2[j][0]) {
			list.add(nums1[i])
			i++
		} else if (nums1[i][0] > nums2[j][0]) {
			list.add(nums2[j])
			j++
		} else {
			list.add(intArrayOf(nums1[i][0], nums1[i][1] + nums2[j][1]))
			i++
			j++
		}
	}

	while (i < nums1.size) {
		list.add(nums1[i])
		i++
	}

	while (j < nums2.size) {
		list.add(nums2[j])
		j++
	}
	return list.toTypedArray()
}