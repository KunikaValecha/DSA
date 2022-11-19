package BinarySearch

/**
 * Bitonic array is first monotonically increasing and then monotonically decreasing
 */

class MaximumInBitonicArray {
    companion object{
        fun getMax(arr:IntArray):Int{
            var start = 0
            var end = arr.size -1
            while (start<=end){
                val mid = start + (end-start)/2
                if(mid>0 && mid<arr.size-1){
                    if(arr[mid]>= arr[mid-1] && arr[mid]>=arr[mid+1]){
                         return  mid
                    }
                    else if(arr[mid]<arr[mid-1]){
                        end = mid -1
                    }
                    else if(arr[mid]< arr[mid+1]){
                        start = mid +1
                    }
                }
                else if(mid== 0 && arr[mid]>arr[mid+1]) {
                    return mid
                }
                else if(mid == arr.size -1 && arr[mid]>arr[mid-1]){
                    return mid
                }


            }
            return -1
        }
    }
}

fun main() {
    println( MaximumInBitonicArray.getMax(intArrayOf(1,2)))
}