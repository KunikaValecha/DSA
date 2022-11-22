package Recursion

import java.util.StringJoiner

class PermutationWithSpaces {
    companion object{
        fun addSpaces(input: String, output :String){
            var i = input
            var o = output
            if(i.isEmpty()){
                print(" '$output'")
                return
            }

            var output1 = output.plus(" "+i.first())
            var output2 = output.plus(i.first())
            i = i.substring(1, i.length)
            addSpaces(i,output1)
            addSpaces(i,output2)

        }
    }
}

fun main() {
    var input = "abc"
    PermutationWithSpaces.addSpaces(input.substring(1,input.length), input.first().toString())
}