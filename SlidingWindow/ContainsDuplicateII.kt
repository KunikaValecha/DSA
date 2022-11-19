package SlidingWindow

import java.util.InputMismatchException

/**
 * 219. Contains Duplicate II

    Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



    Example 1:

    Input: nums = [1,2,3,1], k = 3
    Output: true
    Example 2:

    Input: nums = [1,0,1,1], k = 1
    Output: true
    Example 3:

    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false


    Constraints:

    1 <= nums.length <= 105
    -109 <= nums[i] <= 109
    0 <= k <= 105
 */

class ContainsDuplicateII {
    companion object{
        fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
            var i=0
            var j=1
            if(k==0){
                return false
            }
            while (j<nums.size){
                if(j-i<=k){
                    if(nums[i]==nums[j]){
                        return true
                    }
                    j++
                }
                else{
                    i++
                    j=i+1
                }
                if (j==nums.size&& i<j-1){
                    i++
                    j=i+1
                }
            }

         return false
        }
    }
}

fun main() {
    println(ContainsDuplicateII.containsNearbyDuplicate(nums = intArrayOf(1,2,3,4,5,6,7,8,9,9), 3))
}