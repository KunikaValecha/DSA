package SlidingWindow

/**
 * Finding maximum number in all sub-arrays of given size
 */

class MaximumOfAllSubArray {
    companion object {

        //function takes two arguments the given main array and size of sub arrays
        fun findMaxOfAllSubarray(array: Array<Int>, k: Int): List<Int> {
            var listOfMax = mutableListOf<Int>()
            var list = mutableListOf<Int>()
            var max = Int.MIN_VALUE
            var i = 0
            var j = 0
//            var c =0
            var ans = 0
            while (j < array.size) {
                val itr = listOfMax.iterator()
                while (itr.hasNext()) {
                    if (itr.next() < array[j])
                        itr.remove()
                }
                listOfMax.add(array[j])

                if (j < k - 1) {
                    j++
                } else if (j - i + 1 == k) {
                    if (listOfMax.isNotEmpty()) {
                        list.add(listOfMax.first())
                        ans = listOfMax.first()
                        print("${listOfMax.first()}")


                        if (array[i] == listOfMax.first()) {
                            listOfMax.removeAt(0)
                        }
                    }
                    i++
                    j++
                }
            }
            return list
        }
    }
}

fun main(args: Array<String>) {
    println(MaximumOfAllSubArray.findMaxOfAllSubarray(arrayOf(1, 3, 1, 2, 0, 5), 3))
}