fun maxDistance(arrays: List<List<Int>>): Int {
    var min1 = 10000
    var min2 = 10000
    var max1 = -10000
    var max2 = -10000
    var same = false
    for (array in arrays) {
        val left = array[0]
        if (left < min1) {
            min2 = min1
            min1 = left
        } else if (left < min2) {
            min2 = left
        }
        val right = array[array.size - 1]
        if (right > max1) {
            max2 = max1
            max1 = right
        } else if (right > max2) {
            max2 = right
        }
        if (left == min1 && right == max1) {
            same = true
        }
    }
    return if (same) maxOf(max1 - min2, max2 - min1) else max1 - min1 
}