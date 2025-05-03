import java.util.TreeSet

class NumberContainers() {
	val map = mutableMapOf<Int, TreeSet<Int>>()
	val indexMap = mutableMapOf<Int, Int>()

	fun change(index: Int, number: Int) {
		if (indexMap.containsKey(index)) {
			val oldNumber = indexMap[index]
			map[oldNumber]?.remove(index)
		}
		indexMap[index] = number
		map[number]?.add(index)?: map.put(number, TreeSet(listOf(index)))
	}

	fun find(number: Int): Int {
		if (map[number] == null || map[number]!!.isEmpty()) {
			return -1
		}
		return map[number]!!.first()
	}

}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * var obj = NumberContainers()
 * obj.change(index,number)
 * var param_2 = obj.find(number)
 */