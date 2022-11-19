package Recursion

class DeleteMidOfStack {
    companion object{
        fun delete(stack: ArrayDeque<Int>, k:Int):ArrayDeque<Int>{
            if(k==1){
                stack.removeLast()
            }
            else{
                var temp = stack.last()
                stack.removeLast()
                delete(stack, k-1)
                stack.addLast(temp)
            }
            return stack
        }
    }
}

fun main() {
    val stack = ArrayDeque(listOf(6,7,8,9,10,11,5,4,3,2,1))
    val s = DeleteMidOfStack.delete(stack, stack.size/2 +1)
    for(i in s){
        print(" $i")
    }
}