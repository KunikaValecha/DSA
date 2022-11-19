package BinarySearch

class PositionOfElementInInfiniteSortedArray {
    companion object {
        fun findTheIndex(arr: IntArray, element: Int): Int {
            var start = 0
            var end = 1
            while (arr[end] < element) {
                start = end
                end *= 2
            }
            return binarySearch(arr, start, end, element)
        }

        private fun binarySearch(arr: IntArray, start: Int, end: Int, element: Int): Int {
            var start = start
            var end = end

            while (start <= end) {
                val mid = start + (end - start) / 2
                if (mid == element) {
                    return mid
                } else if (arr[mid] > element) {
                    end = mid - 1
                } else {
                    start = mid + 1
                }

            }
            return -1
        }
    }
}