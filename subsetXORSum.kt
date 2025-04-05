var result = 0

fun subsetXORSum(nums: IntArray): Int {
    helper(nums, 0, 0)
    return result
}

fun helper(nums: IntArray, cur: Int, index: Int) {
    if (nums.size == index) {
        result += cur
        return 
    }
    helper(nums, cur, index + 1)
    helper(nums, cur xor nums[index], index + 1)
}