import kotlin.math.min

fun numSubmat(mat: Array<IntArray>): Int {
	val m = mat.size
	val n = mat[0].size
	val dp = Array(m) { IntArray(n) }
	var sum = 0
	for(i in 0 until m) {
		for(j in 0 until n) {
			if(j == 0) {
				dp[i][j] = mat[i][j]
			} else {
				dp[i][j] = if(mat[i][j] == 0) 0 else dp[i][j - 1] + 1
			}
			var cur = dp[i][j]
			for(k in i downTo 0) {
				cur = min(cur, dp[k][j])
				if(mat[k][j] == 0) {
					break
				}
				sum += cur
			}
		}
	}
	return sum
}