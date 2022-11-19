package BinarySearch

/**
 * 33. Search in Rotated Sorted Array

    There is an integer array nums sorted in ascending order (with distinct values).

    Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

    Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

    You must write an algorithm with O(log n) runtime complexity.



    Example 1:

    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4
    Example 2:

    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1
    Example 3:

    Input: nums = [1], target = 0
    Output: -1


    Constraints:

    1 <= nums.length <= 5000
    -104 <= nums[i] <= 104
    All values of nums are unique.
    nums is an ascending array that is possibly rotated.
    -104 <= target <= 104
 */
class FindAnElementInRotatedSortedArray {
    companion object{
        fun findElement(nums :IntArray, element:Int):Int{
            var start = 0
            var end = nums.size -1
            val indexOfMin = getIndexOfMinimum(nums, start, end)
            var indexOfElement = -1
            if(indexOfMin>0){
                indexOfElement = binarySearch(nums, start, indexOfMin-1,element)
                if(indexOfElement==-1){
                    indexOfElement = binarySearch(nums, indexOfMin, end, element)
                }
            }
            else{
                indexOfElement = binarySearch(nums, indexOfMin, end, element)

            }
            return indexOfElement
        }

        fun binarySearch(arr:IntArray, start:Int, end:Int, element: Int):Int{
            var start = start
            var end = end
            var ans = 0
            while (start<=end){
                val mid = start + (end -start)/2
                if (arr[mid]==element){
                     return mid
                }
                else if(arr[mid]>element){
                    end = mid -1
                }
                else
                    start = mid +1
            }
            return -1
        }

        fun getIndexOfMinimum(arr:IntArray, start:Int, end:Int):Int{
            var start = start
            var end = end
            while(start<=end){
                val mid = start +(end-start)/2
                val prev = (mid+arr.size-1)/arr.size
                val next = (mid+1)/arr.size

                if(arr[mid]<= arr[prev] && arr[mid]<= arr[next])
                    return mid

                if(arr[mid]<=arr[end]){
                    end = mid -1
                }
                else if(arr[start]<= arr[mid]){
                    start = mid +1
                }
            }
            return -1
        }
    }
}

fun main() {
    println( FindAnElementInRotatedSortedArray.findElement(intArrayOf(1,3), 0))
}