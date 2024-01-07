fun applyOperations(nums: IntArray): IntArray {
    var j = 0
    for(i in nums.indices) {
        if(i != nums.size - 1 && nums[i] == nums[i + 1]) {
            nums[i] *= 2
            nums[i + 1] = 0
        }
        if(nums[i] != 0) {
            nums[j] = nums[i].also { nums[i] = nums[j] }
            j++
        }
    }
    return nums
}

/**
 * use nums[j] = nums[i].also { nums[i] = nums[j] } to swap array value in kotlin
 */