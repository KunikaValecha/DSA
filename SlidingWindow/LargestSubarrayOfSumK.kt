package SlidingWindow

/**
 * Find the largest subarray with a given sum
 */

class LargestSubarrayOfSumK {
    companion object{

        //Function takes two arguments the main array in which subarray is to be found
        // and the target sum that is needed to be attained by the returning subarray
        fun getLargestArrayOfSumK(array: IntArray, sum:Int): Int{
            var i =0
            var j =0

            //Initialise a variable to store iterating sum of sub-arrays while we traverse
            var sumNew = 0

            //initialise variable to store the count of arrays iteratively
            var count = 0

            //initialise variable to store the maximum size which gets updated everytime count> maxSum
            var maxSize = 0
            while(j<array.size){

                //jth element to sum
                sumNew += array[j]

                if(sumNew<sum){
                    j++
                }
                else if(sum==sumNew){
                    count = j-i+1
                    i++
                    sumNew=0
                }
                if(count>maxSize){
                    maxSize=count
                }
            }
            return maxSize
        }
    }
}

fun main(){
    println( LargestSubarrayOfSumK.getLargestArrayOfSumK(intArrayOf(4,1,1,-2,1,5), 5))
}