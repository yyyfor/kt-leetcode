import kotlin.math.max

fun maxConsecutive(bottom: Int, top: Int, special: IntArray): Int {
	var max = 0
	special.sort()
	for (i in 0 until special.size - 1) {
		max = max(max, special[i + 1] - special[i] - 1)
	}
	max = maxOf(max, special[0] - bottom , top - special[special.size - 1] , max)
	return max
}