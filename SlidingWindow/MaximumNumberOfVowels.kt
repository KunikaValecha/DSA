package SlidingWindow

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length

    Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

    Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.



    Example 1:

    Input: s = "abciiidef", k = 3
    Output: 3
    Explanation: The substring "iii" contains 3 vowel letters.
    Example 2:

    Input: s = "aeiou", k = 2
    Output: 2
    Explanation: Any substring of length 2 contains 2 vowels.
    Example 3:

    Input: s = "leetcode", k = 3
    Output: 2
    Explanation: "lee", "eet" and "ode" contain 2 vowels.


    Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters.
    1 <= k <= s.length
 */

class MaximumNumberOfVowels {
    companion object{
        fun maxVowels(s: String, k: Int): Int {

            var i =0
            var j=0
            var count =0
            var maxCount = Int.MIN_VALUE
            val vowels = "aeiou"

            while(j<s.length){
                if(vowels.contains(s[j])){
                    count++
                }
                if(j<k-1){
                    j++
                }
                else if(j-i+1 ==k){
                    if(maxCount<count)
                        maxCount =count

                    if(vowels.contains(s[i]))
                        count--
                    i++
                    j++
                }
            }
            return maxCount
        }
    }
}

fun main() {
    println( MaximumNumberOfVowels.maxVowels("leetcode", k = 3))
}