package SlidingWindow

/**
 * 424. Longest Repeating Character Replacement

    You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

    Return the length of the longest substring containing the same letter you can get after performing the above operations.



    Example 1:

    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.
    Example 2:

    Input: s = "AABABBA", k = 1
    Output: 4
    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.


    Constraints:

    1 <= s.length <= 105
    s consists of only uppercase English letters.
    0 <= k <= s.length
 */

class LongestRepeatingCharacterReplacement {
    companion object{
        fun characterReplacement(s: String, k: Int): Int {
            var i=0
            var j=0
            var maxLen =Int.MIN_VALUE
            val hash = hashMapOf<Char, Int>()
            while (j<s.length){
                val value = hash.get(s[j])
                if(value==null){
                    hash.set(s[j],1)
                }
                else{
                    hash.set(s[j], hash.get(s[j])!!+1)
                }
                if(j-i+1 - hash.values.max() <= k){
                   if(maxLen< j-i+1){
                       maxLen = j-i+1
                   }
                    j++
                }

                else{
                    val valueOfIthTerm = hash.get(s[i])
                    if(valueOfIthTerm!=null){
                        if(valueOfIthTerm==1){
                            hash.remove(s[i])
                        }
                        else{
                            hash.set(s[i], hash.get(s[i])!!-1)
                        }
                    }
                    i++
                    j++
                }
            }

        return maxLen
        }
    }
}

fun main() {
    println( LongestRepeatingCharacterReplacement.characterReplacement("AABABBA",1))
}