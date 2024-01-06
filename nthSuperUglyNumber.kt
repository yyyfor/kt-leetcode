import java.util.*

fun main() {
    println(nthSuperUglyNumber(12, intArrayOf(2, 7, 13, 19)))
}

fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
    val queue = PriorityQueue { a: IntArray, b: IntArray ->
        (a[0] - b[0])
    }
    for (i in primes.indices) queue.offer(intArrayOf(primes[i], primes[i], 0))

    val nums = IntArray(n + 1)
    nums[0] = 1

    var i = 1
    while (i < n) {
        val entry = queue.poll()
        println(entry.contentToString())
        val num = entry[0]
        val prime = entry[1]
        val index = entry[2]
        // remove duplicate
        if (num != nums[i - 1]) {
            nums[i] = num
            i++
        }
        queue.offer(intArrayOf(prime * nums[index + 1], prime, index + 1))
    }
    return nums[n - 1]
}