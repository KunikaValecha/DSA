package SlidingWindow

/**
 * 3. Longest Substring Without Repeating Characters

    Given a string s, find the length of the longest substring without repeating characters.



    Example 1:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:

    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


    Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
 */

class LongestSubstringWithNoRepeatingChars {
    companion object{
        fun findLongestSubstring(inputString:String):Int{
            var i =0
            var j=0

            //variable storing max of hashmap size for all sub-arrays with unique chars
            var ansMax =0

            //Initialise a hashmap to store count of all chars in substring
            val hash = HashMap<Char, Int>()

            while (j<inputString.length){
                val value = hash.get(inputString[j])

                //until any key in hash map doesn't correspond to its value as 2
                //keep allocating new key value pair in hashmap
                //keep updating max size of hashmap
                if(value==null){
                    hash.set(inputString[j], 1)
                    j++
                    if(hash.size> ansMax)
                        ansMax=hash.size

                }

                //as soon as value of any key raises to 2,
                //clear hashmap till the point in j-1 substring where 1st occurrence was detected
                //store a key value pair in hashmap for current iteration
                else{
                   while (hash.contains(inputString[j])){
                       hash.remove(inputString[i])
                       i++
                   }
                    hash.set(inputString[j], 1)
                    j++
                }
            }
            return ansMax
        }
    }
}

fun main(){
    println(LongestSubstringWithNoRepeatingChars.findLongestSubstring("dvdf"))
}