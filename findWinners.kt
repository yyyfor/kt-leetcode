fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val win = matches.map { it[0] }.toSet()
    val lose = matches.map { it[1] }.groupingBy { it }.eachCount()
    val list1 = win.minus(lose.keys).toList().sorted()
    val list2 = lose.filter { it.value == 1 }.map { it.key }.toList().sorted()
    return listOf(list1, list2)
}