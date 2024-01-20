fun splitWordsBySeparator(words: List<String>, separator: Char): List<String> {
    return words.map { it.split(separator) }
        .flatten()
        .filter { it.isNotEmpty() }
        .toList()
}

fun main() {
    val l = splitWordsBySeparator(listOf("abc", "bca"), 'b')
    println("result is $l")
}