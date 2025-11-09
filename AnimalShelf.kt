import java.util.*

class AnimalShelf() {
	private val dogs = LinkedList<Animal>()
	private val cats = LinkedList<Animal>()
	var index = 0
	fun enqueue(animal: IntArray) {
		if(animal[1] == 0) {
			cats.offer(Animal(index, animal[0]))
		} else {
			dogs.offer(Animal(index, animal[0]))
		}
		index++
	}

	fun dequeueAny(): IntArray {
		if(dogs.isEmpty() && cats.isEmpty()) {
			return intArrayOf(-1, -1)
		} else if(dogs.isEmpty()) {
			val cat = cats.pollFirst()
			return intArrayOf(cat.num, 0)
		} else if(cats.isEmpty()) {
			val dog = dogs.pollFirst()
			return intArrayOf(dog.num, 1)
		} else {
			val dog = dogs.peekFirst()
			val cat = cats.peekFirst()
			return if(dog.time < cat.time) {
				val d = dogs.pollFirst()
				intArrayOf(d.num, 1)
			} else {
				val c = cats.pollFirst()
				intArrayOf(c.num, 0)
			}
		}
	}

	fun dequeueDog(): IntArray {
		if(dogs.isEmpty()) {
			return intArrayOf(-1, -1)
		}
		val dog = dogs.pollFirst()
		return intArrayOf(dog.num, 1)
	}

	fun dequeueCat(): IntArray {
		if(cats.isEmpty()) {
			return intArrayOf(-1, -1)
		}
		val cat = cats.pollFirst()
		return intArrayOf(cat.num, 0)
	}

}

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * var obj = AnimalShelf()
 * obj.enqueue(animal)
 * var param_2 = obj.dequeueAny()
 * var param_3 = obj.dequeueDog()
 * var param_4 = obj.dequeueCat()
 */

data class Animal(val time: Int, val num: Int) {

}