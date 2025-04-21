import kotlin.math.max
import kotlin.math.min

fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
	var max = 0
	var min = 0
	var sum = 0
	for (diff in differences) {
		sum += diff
		max = max(max, sum)
		min = min(min, sum)
		if (max - min > upper - lower) {
			return 0
		}
	}
	// println(max)
	// println(min)
	return upper - lower - (max - min) + 1
}