package Recursion

class PrintUniqueSubsets {
    companion object{
        var hash = hashMapOf<String, Int>()
        fun getUniqueSubsets(input : String, output: String):HashMap<String, Int>{
            var i = input
            if(i.isEmpty()){
                if(hash.contains(output)){
                    hash.set(output, hash.get(output)!!+1)
                }
                else{
                    hash.set(output, 1)
                }
                return hash
            }
            val output1 = output
            val output2 = output.plus(i.first())
            i = i.substring(1, i.length)
            getUniqueSubsets(i, output1)
            getUniqueSubsets(i, output2)
            return hash
        }
    }
}

fun main() {
    val hash = PrintUniqueSubsets.getUniqueSubsets("aab", "")
    print(hash)
    for((key,value) in hash){
        print(" '$key'")

    }

}