package BinarySearch

class SearchingInBitonicArray {
    companion object{
        fun findElement(arr: IntArray, element: Int):Int{
            val peak = findPeak(arr)
            var ans = binarySearch(arr, 0, peak, element)
            if(ans==-1){
                ans = binartSearchOnDescending(arr, peak, arr.size-1,element)
            }
            return ans
        }

        fun findPeak(arr:IntArray):Int{
            var start =0
            var end = arr.size -1
            while (start<= end){
                val mid = start +(end -start)/2
                if(mid > 0 && mid<arr.size-1){
                    if(arr[mid]>=arr[mid+1] && arr[mid]>=arr[mid-1])
                        return mid
                    else if(arr[mid]<arr[mid+1]){
                        start = mid+1
                    }
                    else{
                        end = mid -1
                    }
                }
                if(mid==0 && arr[mid]>arr[mid+1]){
                    return mid
                }
                else{
                    return  mid +1
                }
                if(mid==arr.size-1 && arr[mid]>arr[mid-1]){
                    return mid
                }
                else{
                    return  mid -1
                }

            }
            return -1
        }

        fun binarySearch(arr:IntArray, start:Int, end :Int, element: Int):Int{
            var start = start
            var end = end

            while (start<=end){
                val mid = start + (end -start)/2
                if(arr[mid]==element){
                    return mid
                }
                else if(arr[mid]>element){
                    end = mid -1
                }
                else{
                    start = mid +1
                }
            }
            return  -1
        }

        fun binartSearchOnDescending(arr:IntArray, start:Int, end :Int, element: Int):Int{
            var start = start
            var end = end

            while (start<=end){
                val mid = start + (end-start)/2
                if(arr[mid]==element){
                    return mid
                }
                else if(arr[mid]<element){
                    start = mid+1
                }
                else{
                    end = mid -1
                }
            }
            return -1
        }
    }
}

fun main() {
    println(SearchingInBitonicArray.findElement(intArrayOf(1,3,8,12,4,2), 4))
}