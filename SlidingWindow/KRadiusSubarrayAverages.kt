package SlidingWindow

/**
 * Leetcode Problem 2090. K Radius Subarray Averages

    You are given a 0-indexed array nums of n integers, and an integer k.

    The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.

    Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.

    The average of x elements is the sum of the x elements divided by x, using integer division. The integer division truncates toward zero, which means losing its fractional part.

    For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.


    Example 1:Input: nums = [7,4,3,9,1,8,5,2,6], k = 3
    Output: [-1,-1,-1,5,4,4,-1,-1,-1]
    Explanation:
    - avg[0], avg[1], and avg[2] are -1 because there are less than k elements before each index.
    - The sum of the subarray centered at index 3 with radius 3 is: 7 + 4 + 3 + 9 + 1 + 8 + 5 = 37.
    Using integer division, avg[3] = 37 / 7 = 5.
    - For the subarray centered at index 4, avg[4] = (4 + 3 + 9 + 1 + 8 + 5 + 2) / 7 = 4.
    - For the subarray centered at index 5, avg[5] = (3 + 9 + 1 + 8 + 5 + 2 + 6) / 7 = 4.
    - avg[6], avg[7], and avg[8] are -1 because there are less than k elements after each index.
 */

class KRadiusSubarrayAverages {
    companion object{
        fun getAverages(nums: IntArray, k: Int): IntArray {

            var j =0
            var i =0
            var sum :Long =0

            //Initialise the output array of same size as input array and all elements of it be -1
            var arr = IntArray(nums.size) { -1}

            while (j<nums.size){

                //iterating through sum of all sub-arrays
                sum+=nums[j]
                if(j<k){
                    j++

                }
                else if(j<2*k && j>=k){
                    j++
                }

                else if(j-i+1 == 2*k +1){
                    //replace j+k th term of array with average of subarray
                    arr[i+k]=(sum/(2*k+1).toLong()).toInt()

                    //Slide window
                    sum -= nums[i]
                    i++
                    j++
                }
            }
            return arr

        }
    }
}

fun main() {
    val arr = KRadiusSubarrayAverages.getAverages(nums = intArrayOf(7,4,3,9,1,8,5,2,6), k = 3)
    for(i in arr){
        print(" $i")
    }
}