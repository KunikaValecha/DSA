package SlidingWindow

/**
 * Finding the first negative number in subarray of given size
 */
class FirstNegativeInSlidingWindow {
    companion object {

        //fun takes two arguments viz. main array in which we need to make sub-arrays of given size k
        fun firstNegative(array: Array<Int>, k: Int) {
            val listOfNegative = arrayListOf<Int>()
            var i = 0
            var j = 0

            while (j < array.size) {
                //adding all negatives to the list of negatives
                if (array[j] < 0) {
                    listOfNegative.add(array[j])
                }
                if (j < k - 1) {
                    j++
                } else if (j - i + 1 == k) {

                    //if list is empty then there is no negative number in sub-array so print 0
                    if (listOfNegative.isEmpty()) {
                        print(" 0")
                    } else {
                        //else always print first element of list of negatives
                        print(listOfNegative.first())

                        //remove the first element of list of negatives if
                        // ith element of array == first element of list of negative
                        if (listOfNegative.first() == array[i]) {
                            listOfNegative.removeFirst()
                        }
                    }
                    //Slide the window
                    i++
                    j++
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    FirstNegativeInSlidingWindow.firstNegative(arrayOf(12, -1, -7, 8, -15, 30, 16, 28), 3)
}
