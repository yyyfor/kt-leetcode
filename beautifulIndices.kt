import kotlin.math.max
import kotlin.math.min

fun beautifulIndices(s: String, a: String, b: String, k: Int): List<Int> {
    val list = mutableListOf<Int>()
    for(i in 0..s.length - a.length) {
        if(s.substring(i, i + a.length) == a) {
            list.add(i)
        }
    }
    println(list)
    val result = mutableSetOf<Int>()
    val visited = mutableSetOf<Int>()
    for(i in list) {
        for(j in max(0, i - k) .. min(i + k, s.length - b.length)) {
            if(visited.contains(j)) {
                continue
            }
            visited.add(j)
            if(s.substring(j, j + b.length) == b) {
                println(j)
                result.add(i)
                break
            }
        }
    }
    return result.toList().sorted()
}

fun main() {
    val l = beautifulIndices("frkxslnnn","rkxsl", "n", 2)
    println("result is $l")
}