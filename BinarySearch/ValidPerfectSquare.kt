package BinarySearch

/**
 * 367. Valid Perfect Square
    Given a positive integer num, write a function which returns True if num is a perfect square else False.

    Follow up: Do not use any built-in library function such as sqrt.



    Example 1:

    Input: num = 16
    Output: true
    Example 2:

    Input: num = 14
    Output: false


    Constraints:

    1 <= num <= 2^31 - 1
 */

class ValidPerfectSquare {
    companion object{
        fun isPerfectSquare(num: Int): Boolean {
            var start = 0
            if(num == 1){
                return true
            }
            var end = num/2

            while(start<=end){
                val mid = start + (end-start)/2
                if(mid*mid.toLong() == num.toLong()){
                    return true
                }
                else if(mid*mid.toLong() > num.toLong()){
                    end = mid -1
                }
                else if(mid*mid.toLong() < num.toLong()){
                    start = mid+1
                }
            }
            return false
        }
    }
}

fun main() {
    println( ValidPerfectSquare.isPerfectSquare(808201))
}