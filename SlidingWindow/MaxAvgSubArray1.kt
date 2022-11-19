package SlidingWindow

/**
 * LeetCode Problem 643. Maximum Average Subarray I
 *
    You are given an integer array nums consisting of n elements, and an integer k.

    Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.



    Example 1:

    Input: nums = [1,12,-5,-6,50,3], k = 4
    Output: 12.75000
    Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
    Example 2:

    Input: nums = [5], k = 1
    Output: 5.00000


    Constraints:

    n == nums.length
    1 <= k <= n <= 105
    -104 <= nums[i] <= 104
 */

class MaxAvgSubArray1 {
    companion object{
        fun findMaxAverage(nums: IntArray, k: Int): Double {
            var i=0
            var j=0
            var sum = 0
            var maxSum = Int.MIN_VALUE

            //SlidingWindow
            while(j<nums.size){
                sum += nums[j]
                if(j<k-1){
                    j++
                }
                else if(j-i+1 == k){
                    if(sum>maxSum){
                        maxSum=sum
                    }
                    sum -= nums[i]

                    //Slide Window
                    i++
                    j++
                }

            }
            return maxSum.toDouble()/k.toDouble()
        }
    }
}

fun main() {
    println(MaxAvgSubArray1.findMaxAverage(intArrayOf(1,12,-5,-6,50,3), k = 4))
}