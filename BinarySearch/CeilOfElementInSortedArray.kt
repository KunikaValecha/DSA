package BinarySearch

class CeilOfElementInSortedArray {
    companion object{
        fun findCeil(arr: IntArray, element:Int):Int{
            var start = 0
            var end = arr.size -1
            var ans = -1

            while (start<=end){
                val mid = start + (end-start)/2
                if(arr[mid]==element){
                    return mid
                }
                else if(arr[mid]<element){
                    start = mid+1
                }
                else if(arr[mid]>element){
                    end = mid -1
                    ans = mid
                }
            }
            return  ans
        }
    }
}

fun main() {
    println(CeilOfElementInSortedArray.findCeil(intArrayOf(1,2,3,4,8,10,10,12,19), 5))
}