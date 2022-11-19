package BinarySearch

/**
 * 34. Find First and Last Position of Element in Sorted Array

    Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

    If target is not found in the array, return [-1, -1].

    You must write an algorithm with O(log n) runtime complexity.



    Example 1:

    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
    Example 2:

    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]
    Example 3:

    Input: nums = [], target = 0
    Output: [-1,-1]


    Constraints:

    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
    nums is a non-decreasing array.
    -109 <= target <= 109
 */

class FirstAndLastOccurrenceOfAnElement {
    companion object{
        fun findFirstAndLastOccurrenceOfElement(arr:IntArray, element: Int):IntArray{
            var start = 0
            var end = arr.size -1
            var firstOccurrence = -1
            var lastOccurrence = -1

            //First Occurrence
            while (start<=end){
                val mid = start + (end-start)/2
                if(element==arr[mid]){
                    firstOccurrence = mid
                    end = mid -1
                }
                else if(arr[mid]> element){
                    end = mid-1
                }
                else{
                    start = mid+1
                }
            }

            //Last Occurrence
            start = 0
            end = arr.size -1
            lastOccurrence = -1
            while (start<=end){
                val mid = start + (end-start)/2
                if(element==arr[mid]){
                    lastOccurrence = mid
                    start = mid +1
                }
                else if(arr[mid]> element){
                    end = mid-1
                }
                else{
                    start = mid+1
                }
            }
            return intArrayOf( firstOccurrence, lastOccurrence)
        }
    }
}

fun main() {
    val arr = FirstAndLastOccurrenceOfAnElement.findFirstAndLastOccurrenceOfElement(intArrayOf(2,5), 5)
    for(i in arr){
        println(i)
    }
}