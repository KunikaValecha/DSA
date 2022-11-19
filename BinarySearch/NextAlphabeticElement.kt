package BinarySearch

import java.util.StringJoiner

class NextAlphabeticElement {
    companion object{
        fun findNextAlphabeticElement(arr:String, element:String):String{
            var start = 0
            var end = arr.length -1
            var ans = "#"

            while (start<=end){
                val mid = start + (end-start)/2
                if(arr[mid]<=element[0]){
                    ans = arr[mid+1].toString()
                    start = mid+1
                }
                else{
                    end = mid-1
                }
            }
            return ans
        }
    }
}

fun main() {
    println( NextAlphabeticElement.findNextAlphabeticElement("abch", "f"))
}