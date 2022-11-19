//package SlidingWindow
//
//import java.util.LongSummaryStatistics
//
//class LongestSubstringWithAtLeastKRepeatingCharacters {
//    companion object{
//        fun longestSubstring(s: String, k: Int): Int {
//            var i=0
//            var j=0
//            var newElement =0
//            var countOfElements =0
//            val hash = hashMapOf<Char, Int>()
//            var maxLen = Int.MIN_VALUE
//
//            while (j<s.length){
//                val value = hash.get(s[j])
//                if(value==null){
//                    hash.set(s[j], 1)
//                    newElement++
//                }
//                else{
//                    hash.set(s[j], hash.get(s[j])!!+1)
//                    if(hash.get(s[j])==k){
//                        countOfElements++
//                    }
//                }
//
//                if(countOfElements<newElement){
//                    j++
//                }
//                else if(countOfElements==newElement){
//                    if(maxLen< j-i+1){
//                        maxLen= j-i+1
//                    }
//                    j++
//                }
//                else if(countOfElements)
//            }
//            return maxLen
//        }
//    }
//}
//
//fun main() {
//    println(LongestSubstringWithAtLeastKRepeatingCharacters.longestSubstring(s = "ababbc", k = 2))
//}