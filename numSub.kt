fun numSub(s: String): Int {
	var sum = 0
	var count = 0
	for (ch in s) {
		if (ch == '1') {
			count++
			sum += count
			sum %= 1_000_000_007
		} else {
			count = 0
		}
	}
	return sum
}

/**
 * https://leetcode.com/problems/number-of-substrings-with-only-1s/description/?envType=daily-question&envId=2025-11-16
 * time complexity: O(n)
 * space complexity: O(1)
 */