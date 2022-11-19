package PrefixSum

class PrefixSum2D {
    companion object{
        fun prefixSum2D(array: Array<Array<Int>>){
            var arr = array
            for(i in arr.indices){
                for (j in arr[i].indices){
                    if(i>0 && j>0)
                        arr[i][j] = arr[i-1][j] + arr[i][j-1]+ array[i][j]- arr[i-1][j-1]
                    else if(i==0 && j==0)
                        arr[i][j] = array[i][j]
                    else if(i==0)
                        arr[i][j] = arr[i][j-1]+array[i][j]
                    else if(j==0)
                        arr[i][j] = arr[i-1][j]+array[i][j]

                }
            }

            for(i in arr.indices){
                for (j in arr[i].indices){
                    print(" ${arr[i][j]}")
                }
                println()
            }
        }
    }
}

fun main(args: Array<String>) {
    PrefixSum2D.prefixSum2D(arrayOf(arrayOf(10,20,30), arrayOf(5,10,20), arrayOf(2,4,6)))
}