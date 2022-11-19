package Recursion

class PrintNto1 {
    companion object{
        fun printNum(num:Int){
            var n = num
            if(n==1){
                print(" 1")
            }
            else{
                print(" $n")
                printNum(n-1)
            }
        }
    }
}

fun main() {
    PrintNto1.printNum(7)
}