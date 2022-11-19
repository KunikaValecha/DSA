package SlidingWindow

/**
 * Return a subString with no repeating characters in it
 */

class LongestSubstringWithKUniqueChar {
    companion object{
        fun findLongestSubstring(inputString: String, k:Int):Int{
          val hash = HashMap<Char, Int>()
          var ans = 0
          var i =0
          var j=0
          var maxAns =0

          while(j<inputString.length){
              val value = hash.get(inputString[j])
              if(value==null){
                  hash.set(inputString[j], 1)
              }
              else
                  hash.set(inputString[j], hash.get(inputString[j])!! +1)

              if(hash.size<k){
                  j++
              }

              else if(hash.size == k){
                  j++
                  ans = j-i
                  if(maxAns<ans){
                      maxAns=ans
                  }
              }

              else if(hash.size >k){
                  while (hash.size>k){
                      if(hash.contains(inputString[i])){
                          var valueToBeDecreased = hash.get(inputString[i])
                          if(valueToBeDecreased==1){
                              hash.remove(inputString[i])
                          }
                          else{
                              hash.set(inputString[i], hash.get(inputString[i])!!-1)
                          }
                      }
                      i++
                  }

                  j++
              }

          }
         return maxAns
        }
    }
}

fun main() {
    println(LongestSubstringWithKUniqueChar.findLongestSubstring("abaccab", 3))
}