package BinarySearch

/**
 *
 */

class SearchElementInNearlySortedArray {
    companion object{
        fun findElement(arr:IntArray, element: Int):Int{
            var start = 0
            var end = arr.size -1

            while(start<end){
                val mid = start + (end-start)/2
                if(arr[mid]== element){
                    return mid
                }
                else if(mid-1>= 0 && arr[mid-1]== element){
                    return mid -1
                }
                else if(mid+1<=arr.size && arr[mid+1]== element){
                    return mid +1
                }
                else if(arr[mid-1]>element){
                    end = mid -2
                }
                else if(arr[mid+1]<element){
                    start = mid+2
                }
                else{
                    return -1
                }
            }
            return -1
        }

    }
}

fun main() {
    println( SearchElementInNearlySortedArray.findElement(intArrayOf(1,2,3,4,7,6,5), 5))
}