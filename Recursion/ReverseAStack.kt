package Recursion

class ReverseAStack {
    companion object{
        fun reverse(stack: ArrayDeque<Int>):ArrayDeque<Int>{

            if(stack.size==0){
                return stack
            }
            else{
                var temp = stack.last()
                stack.removeLast()
                reverse(stack)
                stack.addFirst(temp)
            }
            return stack
        }
    }
}

fun main() {
    val s = ReverseAStack.reverse(ArrayDeque(listOf(1,2,3,4,5,6,7)))
    for(i in s){
        print(" $i")
    }
}