class RedundantConnectionII {
	fun findRedundantDirectedConnection(edges: Array<IntArray>): IntArray {
		val l = edges.size
		val parent = IntArray(l + 1) { it + 1 }
		for (edge in edges) {
			if (!union(parent, edge[0], edge[1])) {
				return edge
			}
		}
		return IntArray(0)
	}

	fun find(parent: IntArray, index: Int): Int {
		if(parent[index] != index) {
			parent[index] = find(parent, parent[index])
		}
		return parent[index]
	}

	fun union(parent: IntArray, i1: Int, i2: Int):Boolean {
		if(find(parent, i1) == find(parent, i2)) {
			return false
		}
		parent[find(parent, i1)] = find(parent, i2)
		return true
	}
}