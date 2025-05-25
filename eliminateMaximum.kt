import java.util.PriorityQueue

fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
	val queue = PriorityQueue<Int>()
	for (i in dist.indices) {
		val time = (dist[i] + speed[i] - 1) / speed[i]
		queue.add(time)
	}
	var count = 0
	var time = 0
	while(queue.isNotEmpty()) {
		val currentTime = queue.poll()
		if (currentTime <= time) {
			return count
		}
		count++
		time++
	}
	return count
}