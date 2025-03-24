fun countDays(days: Int, meetings: Array<IntArray>): Int {
	meetings.sortBy { it[0] }
	var lastIndex = meetings[0][0]
	var count = meetings[0][0] - 1
	for (meeting in meetings) {
		if (meeting[0] > lastIndex) {
			count += meeting[0] - lastIndex - 1
		}
		lastIndex = maxOf(lastIndex, meeting[1])
	}
	count += days - lastIndex
	return count
}