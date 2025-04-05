import kotlin.math.abs

fun longestIdealString(s: String, k: Int): Int {
    var max = 0
    val dp = IntArray(26)
    for (c in s) {
        val tmp = dp[c - 'a']
        for (i in c - 'a' - 2 until c - 'a') {
            if (i in 0..25) {
                dp[c - 'a'] = maxOf(dp[c - 'a'], dp[i] + 1)
            }
        }
        for (i in c - 'a'+ 1  until c - 'a' + 3) {
            if (i in 0..25) {
                dp[c - 'a'] = maxOf(dp[c - 'a'], dp[i] + 1)
            }
        }
        dp[c - 'a'] = maxOf(dp[c - 'a'], tmp + 1)
        max = maxOf(max, dp[c - 'a'])
    }
    return max   
}