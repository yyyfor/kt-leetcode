import kotlin.math.max

fun maxRectangleArea(points: Array<IntArray>): Int {
	points.sortWith(compareBy({ it[1] }, { it[0] }))
	println(points.map { it.joinToString() } )
	var max = -1
	for(i in 0 .. points.size - 4) {
		for(j in i + 1 .. points.size - 3) {
			for(k in j + 1 .. points.size - 2) {
				for(l in k + 1..<points.size) {
					val p1 = points[i]
					val p2 = points[j]
					val p3 = points[k]
					val p4 = points[l]
					if (p1[1] == p2[1] && p1[0] == p3[0] && p2[0] == p4[0] && p3[1] == p4[1]) {
						var index = false
						for(x in points.indices) {
							if(x == i || x == j || x == k || x == l) {
								continue
							}
							val point = points[x]
//							println("point $point")
							if(point[0] >= p1[0] && point[1] >= p1[1] && point[1] <= p4[1] && point[0] <= p4[0]) {
								index = true
								break
							}
						}
						if (!index) {
							max = max(max, (p4[0] - p1[0]) * (p4[1] - p1[1]))
						}
					}
				}
			}
		}

//		println(max)
	}
	return max
}

fun main() {
	println(maxRectangleArea(arrayOf(intArrayOf(1,1), intArrayOf(1,3), intArrayOf(3,1), intArrayOf(3,3))))
	println(maxRectangleArea(arrayOf(intArrayOf(1,1), intArrayOf(1,3), intArrayOf(3,1), intArrayOf(3,3), intArrayOf(2,2))))
	println(maxRectangleArea(arrayOf(intArrayOf(1,1), intArrayOf(1,3), intArrayOf(3,1), intArrayOf(3,3), intArrayOf(1,2), intArrayOf(3,2))))
}