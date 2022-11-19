package BinarySearch

class FloorOfElementInSortedArray {
    companion object{
        fun findFloor(arr:IntArray, element :Int):Int{
            var left =0
            var right = arr.size -1
            var ans = -1
            while (left<=right){
                val mid = left + (right-left)/2
                if(arr[mid]==element){
                    return mid
                }
                else if(arr[mid]<element){
                    left = mid +1
                    ans = mid
                }
                else if(arr[mid]>element){
                    right = mid-1
                }
            }
            return ans
        }
    }
}

fun main() {
    println(FloorOfElementInSortedArray.findFloor(intArrayOf(1,2,3,4,8,10,10,12,19), 5))
}