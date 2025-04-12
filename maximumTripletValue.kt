fun maximumTripletValue(nums: IntArray): Long {
    var max = 0L
    var rightMax = 0
    for (i in nums.size - 1 downTo 2) {
      if (nums[i] > rightMax) {
        rightMax = nums[i]
      } else {
        continue
      }
      var leftMax = 0
      for (j in 0 until i) { 
        val temp = (leftMax - nums[i]).toLong() * rightMax
        if (temp > max) {
          max = temp
        }
        if (nums[j] > leftMax) {
          leftMax = nums[j]
        }
      }
    }       
    return max
}