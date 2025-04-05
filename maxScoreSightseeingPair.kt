fun maxScoreSightseeingPair(values: IntArray): Int {
    var left = values[0]
    var max = 0
    for (i in 1 until values.size) {
        max = maxOf(max, values[i] + left - i)
        if(values[i] + i > left) {
            left = values[i] + i
        }
    }
    return max 
 }