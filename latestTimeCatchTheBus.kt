fun latestTimeCatchTheBus(buses: IntArray, passengers: IntArray, capacity: Int): Int {
	buses.sort()
	passengers.sort()
	var pIndex = 0
	var count = 0
	for (bus in buses) {
		count = 0
		while (count < capacity && pIndex < passengers.size && passengers[pIndex] <= bus) {
			pIndex++
			count++
		}
		//		println("bus $bus")
		//		println("pIndex $pIndex")
	}
	pIndex--
	var result = if (count == capacity) passengers[pIndex] else buses[buses.size - 1]
	while(pIndex >= 0 && passengers[pIndex] == result) {
		pIndex--
		result--
	}
	return result
}

fun main() {
	println(latestTimeCatchTheBus(intArrayOf(20,30,10), intArrayOf(19,13,26,4,25,11,21), 2))
	println(latestTimeCatchTheBus(intArrayOf(20,10), intArrayOf(2,17,18,19), 2))
	println(latestTimeCatchTheBus(intArrayOf(3), intArrayOf(2,4), 2))
}