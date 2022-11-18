package Recursion

class SortStack {
    companion object{
        fun sort(stack: ArrayDeque<Int>):ArrayDeque<Int>{
            if(stack.size==1){
                return stack
            }
            else{
                var temp = stack.removeLast()
                sort(stack)
                insert(stack, temp)
            }
            return stack
        }

        fun insert(stack: ArrayDeque<Int>, temp:Int){
            if(stack.isEmpty() || stack.last()<=temp){
                stack.addLast(temp)
                return
            }
            else{
                var value = stack.last()
                stack.removeLast()
                insert(stack, temp)
                stack.addLast(value)
            }
        }
    }
}

fun main() {
    val stackSorted = SortStack.sort(ArrayDeque(listOf(3,5,4,2,6)))
    for(i in stackSorted)
        print(" $i")
}