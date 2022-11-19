class Factorial {
    companion object{
        fun findFactorial(num:Int):Int{
            return if(num>=1){
                num * findFactorial(num-1)
            } else{
                1
            }
        }
    }
}

fun main() {
    println(Factorial.findFactorial(5))
}