package BinarySearch

class First1InBinarySortedInfiniteArray {
    companion object{
        fun findFirst1(arr:IntArray, element:Int):Int{
            var start = 0
            var end = 1
            while(arr[end]<element){
                start = end
                end *= 2
            }

            return findFirstOccurrence(arr, start, end, element)
        }

        fun findFirstOccurrence(arr:IntArray, start:Int, end:Int, element: Int):Int{
            var start  = start
            var end = end
            var ans = -1
            while (start<=end){
                val mid = start + (end-start)/2
                if(arr[mid]==element){
                    ans = mid
                    end = mid -1
                }
                if(arr[mid]<element){
                    start = mid +1
                }
                else{
                    end = mid -1
                }
            }
            return  ans
        }
    }
}