fun sortTheStudents(score: Array<IntArray>, k: Int): Array<IntArray> {
	return score.sortedWith(compareByDescending { it[k] }).toTypedArray()
}


