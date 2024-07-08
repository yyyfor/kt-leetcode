
fun countPaths(n: Int, roads: Array<IntArray>): Int {
	val array =  Array(n) { LongArray(n) { Long.MAX_VALUE / 2 } }
	for (road in roads) {
		array[road[0]][road[1]] = road[2].toLong()
		array[road[1]][road[0]] = road[2].toLong()
	}
	val visited = BooleanArray(n)
	val dis = LongArray(n) {  Long.MAX_VALUE / 2 }
	dis[0] = 0
	val c = IntArray(n)
	c[0] = 1
	while (true) {
		var x = -1
		for (i in 0 until n) {
			if (!visited[i] && (x < 0 || dis[i] < dis[x])) {
				x = i
			}
		}
		if(x == n - 1) {
			return c[x]
		}

		visited[x] = true
		for (y in 0 until n) {
			val temp = dis[x] + array[x][y]
			if (temp < dis[y]) {
				dis[y] = temp
				c[y] = c[x]
			} else if(temp == dis[y]) {
				c[y] = (c[x] + c[y]) % 1_000_000_007
			}
		}
	}
}

fun main() {
	countPaths(7, arrayOf(intArrayOf(0,6,7), intArrayOf(0,1,2),
		intArrayOf(1,2,3), intArrayOf(1,3,3), intArrayOf(6,3,3), intArrayOf(3,5,1), intArrayOf(6,5,1),
		intArrayOf(2,5,1), intArrayOf(0,4,5), intArrayOf(4,6,2)
	))
}
