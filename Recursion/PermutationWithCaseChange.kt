package Recursion

class PermutationWithCaseChange {
    companion object{
        fun printPermutations(input: String, output:String){
            var i = input
            if(i.isEmpty()){
                print(" '$output'")
                return
            }
            var output1 = output.plus(i.first().toUpperCase())
            var output2 = output.plus(i.first())
            i = i.substring(1,i.length)
            printPermutations(i, output1)
            printPermutations(i,output2)
        return
        }
    }
}

fun main() {
    PermutationWithCaseChange.printPermutations("ab", "")
}