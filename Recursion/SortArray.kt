class SortArray {
    companion object {
        fun sort(arr: MutableList<Int>):IntArray{

            if (arr.size == 1) {
                return arr.toIntArray()
            } else {
                var value = arr[arr.size - 1]
                arr.removeAt(arr.size-1)
                sort(arr)
                insert(arr, value)
            }
            return arr.toIntArray()
        }

        fun insert(arr:MutableList<Int>, temp:Int){
            if(arr.isEmpty() || arr[arr.size-1]<=temp){
                arr.add(temp)
                return
            }
           var value = arr[arr.size-1]
            arr.removeAt(arr.size-1)
            insert(arr, temp)
            arr.add(value)
            return
        }


    }
}

fun main() {
   var arr = SortArray.sort(mutableListOf(3,2,7,4,1))

    for(i in arr){
        print(" $i")
    }

}