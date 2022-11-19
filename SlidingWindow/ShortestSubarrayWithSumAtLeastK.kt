package SlidingWindow

class ShortestSubarrayWithSumAtLeastK {
    companion object{
        fun shortestSubarray(nums: IntArray, k: Int): Int {
            var i =0
            var j =0
            var sum =0
            var len =0
            var minLen = Int.MAX_VALUE

            while (j<nums.size){
                sum +=nums[j]

                if(sum<k){
                    j++
                }
                else if(sum>=k){

                    while (sum>=k){

                        sum-=nums[i]
                        i++
                    }
                    if(nums[i]>0){
                        len = j-i+1
                        if(len<minLen){
                            minLen = len
                        }
                    }
                    else{
                        len = j-i
                        if(len<minLen){
                            minLen = len
                        }
                    }

                    j++
                }
            }
            if(minLen==Int.MAX_VALUE){
                return -1
            }else{
                return minLen
            }
        }
    }
}

fun main() {
    println(ShortestSubarrayWithSumAtLeastK.shortestSubarray(nums = intArrayOf(84,-37,32,40,95),167))
}