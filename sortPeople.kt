fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
	return names.zip(heights.toList()).sortedByDescending { it.second }
		.map { it.first }.toTypedArray()
}