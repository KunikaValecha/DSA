package SlidingWindow

/**
 * Leetcode Problem 2269. Find the K-Beauty of a Number

    The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that meet the following conditions:

    It has a length of k.
    It is a divisor of num.
    Given integers num and k, return the k-beauty of num.

    Note:

    Leading zeros are allowed.
    0 is not a divisor of any value.
    A substring is a contiguous sequence of characters in a string.
*/


class FindKBeautyNumber {
    companion object{
        fun divisorSubstrings(num: Int, k: Int): Int {
            var input = num.toString()
            var i =0
            var j =0
            var inputInt =0
            var count = 0

            while(j<input.length){
                if(j<k-1){
                    j++
                }
                else if(j-i+1==k){
                    inputInt = (input.substring(i,j+1)).toInt()
                    if(inputInt!=0){
                        if(num%inputInt==0)
                            count++
                    }
                    i++
                    j++
                }
            }
            return count

        }
    }
}

fun main() {
    println(FindKBeautyNumber.divisorSubstrings(240, 2))
}