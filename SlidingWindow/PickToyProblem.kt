package SlidingWindow

/**
 * Given a shelf of toy one with nn types of toys in it is supposed to pick only
 * given k type of toys that too sequentially
 * Logic is same as largest subarray with k unique elements in it
 */

class PickToyProblem {
    companion object{
        fun pickToy(toysOnShelf: String, typeOfToys:Int):Int{
            var i =0
            var j=0
            val hash = HashMap<Char, Int>()
            var totalToysPicked =0
            var maxToysPicked =0

            while (j<toysOnShelf.length){
                val value = hash.get(toysOnShelf[j])
                if(value==null){
                    hash.set(toysOnShelf[j], 1)
                }
                else{
                    hash.set(toysOnShelf[j], hash.get(toysOnShelf[j])!!+1)
                }
                if(hash.size<typeOfToys){
                    j++
                }

                else if(hash.size==typeOfToys){
                    j++
                    totalToysPicked = hash.values.sum()
                    if(maxToysPicked<totalToysPicked)
                        maxToysPicked=totalToysPicked
                }

                else if(hash.size>typeOfToys){
                    while (hash.size>typeOfToys){

                        if(hash.contains(toysOnShelf[i])){
                            var valueToBeDecreased = hash.get(toysOnShelf[i])
                            if(valueToBeDecreased==1){
                                hash.remove(toysOnShelf[i])
                            }
                            else{
                                hash.set(toysOnShelf[i], hash.get(toysOnShelf[i])!!-1)
                            }
                        }
                        i++
                    }
                    j++
                }
            }
        return maxToysPicked
        }
    }
}

fun main() {
    println(PickToyProblem.pickToy("abaccab", 2))
}