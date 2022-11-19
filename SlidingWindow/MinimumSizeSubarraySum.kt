package SlidingWindow

/**
 * LeetCode Problem 209. Minimum Size Subarray Sum
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



    Example 1:

    Input: target = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: The subarray [4,3] has the minimal length under the problem constraint.
    Example 2:

    Input: target = 4, nums = [1,4,4]
    Output: 1
    Example 3:

    Input: target = 11, nums = [1,1,1,1,1,1,1,1]
    Output: 0


    Constraints:

    1 <= target <= 109
    1 <= nums.length <= 105
    1 <= nums[i] <= 104


    Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n))
 */

class MinimumSizeSubarraySum {
    companion object{
        fun minSubArrayLen(target: Int, nums: IntArray): Int {
            var i =0
            var j =0
            var minLen =Int.MAX_VALUE
            var sum =0

            while (j<nums.size){
                sum+= nums[j]
                if(sum<target){
                    j++
                }
                else if(sum>=target){
                    while(sum>=target){
                        sum-=nums[i]
                        val newLength = j - i + 1
                        if (minLen > newLength) {
                            minLen = newLength
                        }
                        i++
                    }
                    j++
                }
            }
            if(minLen==Int.MAX_VALUE){
                return 0
            }
            else{
                return minLen
            }
        }
    }
}

fun main() {
    println(MinimumSizeSubarraySum.minSubArrayLen(target = 11, nums = intArrayOf(1,1,1,1,1,1,1,1)))
}