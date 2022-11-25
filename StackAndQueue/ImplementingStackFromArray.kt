package StackAndQueue

class ImplementingStackFromArray {

        private var top = -1
        private var list = mutableListOf<Int>()
        fun push(element: Int){
            top += 1
            list.add(element)
        }
        fun top():Int{
           return top
        }

        fun pop(){
            top =-1
            list.removeLast()
        }

        fun size(): Int{
            return top +1
        }

        fun isEmpty():Boolean{
            return top == -1
        }

}

fun main() {
    var stack = ImplementingStackFromArray()
    stack.push(1)
    print(stack.isEmpty())
}