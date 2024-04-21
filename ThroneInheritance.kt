import java.util.*

class ThroneInheritance(kingName: String) {

    private val king = Successor(kingName)
    private val map = mutableMapOf(kingName to king)

    fun birth(parentName: String, childName: String) {
        val people = Successor(childName)
        map.get(parentName)!!.lists + people
        map[childName] = people
    }

    fun death(name: String) {
        map.remove(name)
    }

    fun getInheritanceOrder(): List<String> {
        var list = mutableListOf<String>()
        var linkedList = LinkedList<Successor>()
        linkedList.add(king)
        while(!linkedList.isEmpty()) {
            val size = linkedList.size
            for(i in 0 until size) {
                val node = linkedList.poll()
                if(map.containsKey(node.name)) {
                    list.add(node.name)
                }
                linkedList.addAll(node.lists)
            }
        }
        return list
    }

}

data class Successor(
    val name:String = "",
    val lists:List<Successor> = mutableListOf<Successor>()) {
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * var obj = ThroneInheritance(kingName)
 * obj.birth(parentName,childName)
 * obj.death(name)
 * var param_3 = obj.getInheritanceOrder()
 */