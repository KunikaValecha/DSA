package SlidingWindow

import java.lang.Math.abs

/**
 * 220. Contains Duplicate III

    You are given an integer array nums and two integers indexDiff and valueDiff.

    Find a pair of indices (i, j) such that:

    i != j,
    abs(i - j) <= indexDiff.
    abs(nums[i] - nums[j]) <= valueDiff, and
    Return true if such pair exists or false otherwise.



    Example 1:

    Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
    Output: true
    Explanation: We can choose (i, j) = (0, 3).
    We satisfy the three conditions:
    i != j --> 0 != 3
    abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
    abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
    Example 2:

    Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
    Output: false
    Explanation: After trying all the possible pairs (i, j), we cannot satisfy the three conditions, so we return false.


    Constraints:

    2 <= nums.length <= 105
    -109 <= nums[i] <= 109
    1 <= indexDiff <= nums.length
    0 <= valueDiff <= 109
 */

class ContainsDuplicateIII {
    companion object{
        fun containsNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
            var i =0
            var j =0

            while (j<nums.size){
                if(j-i<=indexDiff){
                    if(abs(nums[j]-nums[i])<=valueDiff && j!=i){
                        return true
                    }
                    j++
                }
                else{
                    i++
                    j=i+1
                }
                if(j==nums.size && i<j-1){
                    i++
                    j=i+1
                }
            }
        return false
        }
    }
}

fun main() {
    println( ContainsDuplicateIII.containsNearbyAlmostDuplicate(nums = intArrayOf(1,5,9,1,5,9), indexDiff = 2, valueDiff = 3))
}