package StackAndQueue

import java.util.*

class BalancedBrackets {
    companion object{
        fun checkIfBalanced(string: String):Boolean{
            var stack = Stack<Char>()
            for(i in string.indices){
                if(string[i]== '(' || string[i]== '[' || string[i]== '{'){
                    stack.push(string[i])
                }
                else{
                    if(stack.empty()){
                        return false
                    }
                    var c = stack.peek()
                    stack.pop()
                    if((c=='(' && string[i]== ')') || (c=='[' && string[i]== ']') ||  (c=='{' && string[i]== '}')){
                    }
                    else{
                        return false
                    }
                }
            }
            return stack.empty()
        }
    }
}

fun main() {
    print( BalancedBrackets.checkIfBalanced("{[]}"))
}