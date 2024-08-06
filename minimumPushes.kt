/**
 * https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/description/?envType=daily-question&envId=2024-08-06
 */
fun minimumPushes(word: String): Int {
	val array = IntArray(26)
	for(ch in word) {
		array[ch - 'a']++
	}

	val list = array.sorted()
	var result = 0
	var count = 0
	var num = 1
	println(list)
	for ( i in 25 downTo 0) {
		if(list[i] == 0) return result
		result += num * list[i]
		count++
		if(count % 8 == 0) {
			num++
		}
	}
	return result
}

fun main() {
//	minimumPushes("aaabbbccc")
//	println(minimumPushes("abcde"))
	println(minimumPushes("aabbccddeeffgghhiiiiii"))
}