fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
	val max = candies.max()
	val result = mutableListOf<Boolean>()
	for (candie in candies.withIndex()) {
		if (candie.value + extraCandies >= max) {
			result.add(true)
		} else {
			result.add(false)
		}
	}
	return result
}