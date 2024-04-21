import java.util.*

class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val map = mutableMapOf<Int, MutableSet<Int>>()
        for(edge in edges) {
            var set = map.getOrPut(edge[0]) { mutableSetOf() }
            set.add(edge[1])
            set = map.getOrPut(edge[1]) { mutableSetOf() }
            set.add(edge[0])
        }

        val list = LinkedList<Int>()
        val visited = mutableSetOf<Int>()
        list.add(source)
        visited.add(source)
        while(!list.isEmpty()) {
            var size = list.size
            for(i in 0 until size) {
                val num = list.poll()
                if(num == destination) {
                    return true
                }
                visited.add(num)
                if(map.get(num) == null) {
                    continue
                }
                for(n in map.get(num)!!) {
                    if(!visited.contains(n)) {
                        list.add(n)
                    }
                }
            }
        }
        return false
    }
}