package BinarySearch

/**
 * 162. Find Peak Element

    A peak element is an element that is strictly greater than its neighbors.

    Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

    You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

    You must write an algorithm that runs in O(log n) time.



    Example 1:

    Input: nums = [1,2,3,1]
    Output: 2
    Explanation: 3 is a peak element and your function should return the index number 2.
    Example 2:

    Input: nums = [1,2,1,3,5,6,4]
    Output: 5
    Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.


    Constraints:

    1 <= nums.length <= 1000
    -231 <= nums[i] <= 231 - 1
    nums[i] != nums[i + 1] for all valid i.
 */
class FindPeakElement {
    companion object{
        fun findPeak(arr:IntArray):Int{
            var start = 0
            var end = arr.size -1

            while (start<=end){
                val mid = start + (end -start)/2
                if(mid >0 && mid <arr.size -1){
                    if(arr[mid]>= arr[mid-1] && arr[mid]>= arr[mid+1]){
                        return mid
                    }
                    else if(arr[mid]< arr[mid-1]){
                        end = mid -1
                    }
                    else if(arr[mid]<arr[mid +1]){
                        start = mid +1
                    }
                }
                if(mid == 0 && arr[mid]> arr[mid+1]){
                    return mid
                }
                else if(mid == 0 && arr[mid]< arr[mid+1]) {
                    return mid +1
                }
                if(mid == arr.size -1 && arr[mid]>arr[mid-1]){
                    return mid
                }
                else if(mid == arr.size -1 && arr[mid]<arr[mid-1]){
                    return mid -1
                }

            }
            return  -1
        }
    }
}

fun main() {
    println(FindPeakElement.findPeak(intArrayOf(1,2,1,3,5,6,4)))
}