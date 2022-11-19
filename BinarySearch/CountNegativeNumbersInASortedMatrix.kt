package BinarySearch

/**
 * 1351. Count Negative Numbers in a Sorted Matrix
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.



    Example 1:

    Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
    Output: 8
    Explanation: There are 8 negatives number in the matrix.
    Example 2:

    Input: grid = [[3,2],[1,0]]
    Output: 0


    Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    -100 <= grid[i][j] <= 100

 */
class CountNegativeNumbersInASortedMatrix {
    companion object{
        fun countNegatives(grid: Array<IntArray>): Int {
            var i =0
            var j = grid[0].size -1
            var countOfNegatives = 0

            while(i <= grid.size -1 && i>= 0 && j>= 0  && j<= grid[0].size -1){
                if(grid[i][j]<0){
                    countOfNegatives += (grid.size) - i
                    j--
                }
                else if(grid[i][j]>=0){
                    i++
                }

                else if(i == grid.size -1 && j == grid[0].size -1 && grid[i][j]>=0)
                    break
            }
            return countOfNegatives
        }
    }
}

fun main() {
    println(CountNegativeNumbersInASortedMatrix.countNegatives(arrayOf(intArrayOf(3,2),
        intArrayOf(5,1,0), intArrayOf(-5,-5,-5))))
}