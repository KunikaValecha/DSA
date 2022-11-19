package BinarySearch

class MinimumDifferenceElementInSortedArray {
    companion object{
        fun findingElement(arr:IntArray, key:Int):Int{
            var start = 0
            var end = arr.size -1
            var floor = -1
            var ceil = -1
            while (start<=end){
                val mid = start + (end - start)/2
                if(arr[mid]==key)
                    return mid
                else if(arr[mid]<key){
                    floor = mid
                    start = mid +1
                }
                else{
                    ceil = mid
                    end = mid -1
                }
            }

            val diffLeft = key - arr[floor]
            val diffRight = arr[ceil]-key

            if(diffLeft<diffRight){
                return floor
            }
            else
                return ceil

        }
    }
}

fun main() {
    println(MinimumDifferenceElementInSortedArray.findingElement(intArrayOf(1,3,8,10,15), key = 2))
}