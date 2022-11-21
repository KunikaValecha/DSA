package Recursion

class PrintSubsets {
    companion object{
        fun getSubsets(input:String, output:String){
            var i = input
            if(i.isEmpty()){
                print(" '$output'")
                return
            }
            var output1 = output
            var output2 = output
            output2 = output2.plus(i.first().toString())
            i = i.substring(1, i.length)
            getSubsets(i, output1)
            getSubsets(i, output2)
            return
        }
    }
}

fun main() {
    PrintSubsets.getSubsets("ab", "")
}