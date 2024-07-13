import java.util.*

class TopVotedCandidate(persons: IntArray, times: IntArray) {
	private val map = mutableMapOf<Int,Int>()
	private val treeMap = TreeMap<Int,Int>()
	private var lead = -1
	init {
		for(i in persons.indices) {
			val value = map.getOrDefault(persons[i], 0) + 1
			map[persons[i]] = value
			if(lead == -1 || value >= map[lead]!!) {
				lead = persons[i]
			}
			treeMap[times[i]] = lead
		}
	}

	fun q(t: Int): Int {
		println(treeMap.floorEntry(t))
		return treeMap.floorEntry(t).value
	}

}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * var obj = TopVotedCandidate(persons, times)
 * var param_1 = obj.q(t)
 */

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * var obj = TopVotedCandidate(persons, times)
 * var param_1 = obj.q(t)
 */