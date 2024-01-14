

fun closeStrings(word1: String, word2: String): Boolean {
    if(word1.length != word2.length) {
        return false
    }

    val map1 = word1.groupingBy { it }.eachCount()
    val map2 = word2.groupingBy { it }.eachCount()
    // println(map1.values)
    // println(map2.values)
    return map1.keys == map2.keys && map1.values.toList().sorted() == map2.values.toList().sorted()
}


fun main() {
   println(closeStrings("abc", "bca"))
}