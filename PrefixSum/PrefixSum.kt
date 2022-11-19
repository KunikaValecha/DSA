package PrefixSum

class PrefixSum {
    companion object{
        fun prefixSum(array: Array<Int>):Array<Int>{
            var sum = 0
            var arr = array

            for(i in arr.indices){

                sum += arr[i]
                arr[i] = sum
            }
            return array
        }
    }
}

fun main(args: Array<String>) {
    val arr = PrefixSum.prefixSum(arrayOf(10,20,30,40,50))
    for(element in arr){
        print(" ${element},")
    }
}