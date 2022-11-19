package Recursion

class Print1toN {
    companion object{
        fun printNum(num:Int){
            var n = num
            if(n==1){
                print(" 1")
            }
            else{
                printNum(n-1)
                print(" $n")

            }
        }
    }
}

fun main() {
    Print1toN.printNum(7)
}