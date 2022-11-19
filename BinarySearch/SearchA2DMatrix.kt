package BinarySearch

/**
 * 74. Search a 2D Matrix

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */

class SearchA2DMatrix {
    companion object {
        fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
            //First find the row in which element could be present
            var row = traverseThroughRows(matrix, target)

            //If element wasn't found in any of the rows return false
            if (row == -1) {
                return false
            } else {
                //Else traverse through found row across columns
                return traverseThroughColumns(matrix, target, row)
            }
            return false
        }

        //Tricky part- compare the target from first and last element of each row
        //traverse through rows in binary fashion
        fun traverseThroughRows(matrix: Array<IntArray>, target: Int): Int {
            var start = 0
            var end = matrix.size - 1
            var row = -1
            while (start <= end) {
                val mid = start + (end - start) / 2
                if (target >= matrix[mid][0] && target <= matrix[mid][matrix[0].size - 1]) {
                    row = mid
                    break
                } else if (target < matrix[mid][0]) end = mid - 1
                else if (target > matrix[mid][matrix[0].size - 1]) {
                    start = mid + 1
                }
            }
            return row
        }

        //Using simple binary search on 1D array
        fun traverseThroughColumns(matrix: Array<IntArray>, target: Int, row: Int): Boolean {
            var left = 0
            var right = matrix[0].size - 1

            while (left <= right) {
                val midj = left + (right - left) / 2
                if (matrix[row][midj] == target) return true
                else if (matrix[row][midj] > target) right = midj - 1
                else if (matrix[row][midj] < target) left = midj + 1
            }
            return false
        }

    }
}


fun main() {
    println(
        SearchA2DMatrix.searchMatrix(
            matrix = arrayOf(
                intArrayOf(1)
            ), target = 0
        )
    )
}