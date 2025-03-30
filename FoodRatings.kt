import java.util.*

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
	private val cuisineMap = mutableMapOf<String, TreeSet<Food>>()
	private val foodMap = mutableMapOf<String, Food>()
	init {
		for (i in foods.indices) {
			val cuisine = cuisines[i]
			val food = Food(ratings[i],foods[i], cuisine)
			foodMap[foods[i]] = food
			cuisineMap.getOrPut(cuisine) { TreeSet() }.add(food)
		}
	}

	fun changeRating(food: String, newRating: Int) {
		val oldFood = foodMap[food]!!
		cuisineMap[oldFood.cuisine]!!.remove(oldFood)
		val newFood = Food(newRating, food, oldFood.cuisine)
		foodMap[newFood.name] = newFood
		cuisineMap[oldFood.cuisine]!!.add(newFood)
	}

	fun highestRated(cuisine: String): String {
		return cuisineMap[cuisine]!!.last().name
	}

}

class Food(private val rating: Int, val name: String, val cuisine: String):Comparable<Food> {

	//compare by rating, name
	override fun compareTo(other: Food): Int {
		if(rating.compareTo(other.rating) != 0) {
			return rating.compareTo(other.rating)
		}
		for (i in 0 until minOf(name.length, other.name.length)) {
			if (name[i] != other.name[i]) {
				return other.name[i].compareTo(name[i])
			}
		}
		return name.length.compareTo(other.name.length)
	}
}
