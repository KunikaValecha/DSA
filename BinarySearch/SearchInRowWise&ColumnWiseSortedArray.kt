package BinarySearch

import java.util.Arrays

class SearchInRowWiseColumnWiseSortedArray {
    companion object {
        fun searchKey(arr: Array<IntArray>, key: Int): IntArray {
            var i = 0
            var j = arr[0].size - 1

            while (i <= arr.size - 1 && i >= 0 && j >= 0 && j <= arr[0].size - 1) {
                if (arr[i][j] == key) {
                    return intArrayOf(i, j)
                } else if (arr[i][j] > key) {
                    j--
                } else if (arr[i][j] < key) {
                    i++
                }
            }
            return intArrayOf(-1)
        }
    }
}

fun main() {
    val arr = SearchInRowWiseColumnWiseSortedArray.searchKey(
        arrayOf(
            intArrayOf(10, 20, 30, 40),
            intArrayOf(15, 25, 35, 45),
            intArrayOf(27, 29, 37, 48),
            intArrayOf(32, 33, 39, 50)
        ), 25
    )

    for( i in arr){
        print(i,)
    }

}