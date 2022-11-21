package Recursion

class PowerFunction {
    companion object {
        var ans = 0.0
        fun myPow(x: Double, n: Int): Double {
            var y = 0.0
            var m = 0

            if (n >= 0) {
                y = x
                m = n
            } else {
                y = 1 / x
                m = Math.abs(n)
            }
            if (m == 1 || ans == x) {
                return y
            }
//            else if(y== y* myPow(y, m-1)){
//                return y
//            }
            else {
                y *= myPow(y, m - 1)
                ans = y
            }
            return y


        }


    }
}

fun main() {
    println(PowerFunction.myPow(0.00001, 2147483647))
}