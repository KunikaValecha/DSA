package SlidingWindow

/**
 * Find a sub-array with the largest sum of size k
 */

class LargestSumSubarrayOfSizeK {
    companion object{

        //fun take two arguments main array and size of sub-arrays
        fun getSubarray(array:IntArray, k:Int):Int{
            var i=0
            var j=0

            //Initialise a variable to store sum in every iteration
            var sum=0

            //Initialise a variable to store maximum sum inn every iteration
            var maxSum=0

            //Start Sliding window
            while (j<array.size){

                //add jth element of array to sum
                sum+=array[j]

                //until j doesn't hit window size increment j
                if(j<k-1){
                    j++
                }

                else if(j-i+1 ==k ){

                    //as soon as j hits window size compare maxSum and sum
                    if(maxSum<sum)
                        maxSum=sum

                    //subtract ith element from sum
                    sum-=array[i]

                    //slide the window
                    i++
                    j++
                }
            }
            return maxSum
        }
    }
}

fun main() {
    println( LargestSumSubarrayOfSizeK.getSubarray(intArrayOf(2,5,1,8,2,9,1),3))
}