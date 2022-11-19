package BinarySearch

class SearchInsertPosition {
    companion object {
        fun searchInsert(nums: IntArray, target: Int): Int {
            if (target > nums[nums.size - 1]) {
                return nums.size
            } else {
                return binarySearch(nums, 0, nums.size - 1, target)
            }

        }

        fun binarySearch(arr: IntArray, start: Int, end: Int, target: Int): Int {
            var start = start
            var end = end

            while (start <= end) {
                val mid = start + (end - start) / 2

                if (arr[mid] == target) {
                    return mid
                }
                else if(mid-1>=0 && arr[mid-1]<target && arr[mid]>=target){
                    return mid
                }
                else if(mid+1<=arr.size && arr[mid+1]>=target && arr[mid]<target){
                    return mid+1
                }
                else if (arr[mid] > target) {
                    end = mid
                } else if (arr[mid+1] < target) {
                    start = mid+1
                }

            }
            return -1
        }
    }
}

fun main() {
    println(SearchInsertPosition.searchInsert(intArrayOf(1,3,5), 1))
}