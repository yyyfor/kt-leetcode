import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class amountOfTime {

    //You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
    //
    //Each minute, a node becomes infected if:
    //
    //The node is currently uninfected.
    //The node is adjacent to an infected node.
    //Return the number of minutes needed for the entire tree to be infected.

    fun minTime(root: TreeNode?, start: Int): Int {
        val map = HashMap<Int, ArrayList<Int>>()
        //generate map
        generateMap(root, map)
        val queue = LinkedList<Int>()
        queue.offer(start)
        var time = 0
        val visited = mutableSetOf<Int>()
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val node = queue.poll()
                if (map.containsKey(node)) {
                    for (neighbor in map[node]!!) {
                        if(!visited.contains(neighbor)) {
                            queue.offer(neighbor)
                            visited.add(neighbor)
                        }

                    }
                }
            }
            time++
        }
        return time
    }
    fun generateMap(node: TreeNode?, map: HashMap<Int, ArrayList<Int>>) {
        if (node == null) return
        if (node.left != null) {
            if (map.containsKey(node.`val`)) {
                map[node.`val`]!!.add(node.left!!.`val`)
            } else {
                map[node.`val`] = arrayListOf(node.left!!.`val`)
            }
            if (map.containsKey(node.left!!.`val`)) {
                map[node.left!!.`val`]!!.add(node.`val`)
            } else {
                map[node.left!!.`val`] = arrayListOf(node.`val`)
            }
        }
        if (node.right != null) {
            if (map.containsKey(node.`val`)) {
                map[node.`val`]!!.add(node.right!!.`val`)
            } else {
                map[node.`val`] = arrayListOf(node.right!!.`val`)
            }
            if (map.containsKey(node.right!!.`val`)) {
                map[node.right!!.`val`]!!.add(node.`val`)
            } else {
                map[node.right!!.`val`] = arrayListOf(node.`val`)
            }
        }
        generateMap(node.left, map)
        generateMap(node.right, map)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}