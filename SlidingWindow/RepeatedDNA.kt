package SlidingWindow

/**
 * Leetcode 187. Repeated DNA Sequences
 *
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
     For example, "ACGAATTCCG" is a DNA sequence.
    When studying DNA, it is useful to identify repeated sequences within the DNA.

    Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.



    Example 1:

    Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    Output: ["AAAAACCCCC","CCCCCAAAAA"]
    Example 2:

    Input: s = "AAAAAAAAAAAAA"
    Output: ["AAAAAAAAAA"]


    Constraints:

    1 <= s.length <= 105
    s[i] is either 'A', 'C', 'G', or 'T'.

 */


class RepeatedDNA {

    companion object {

        //function takes the string denoting DNA molecule
        //Returns list of 10-char long strings that are being repeated in given DNA sequence
        fun findRepeatedDnaSequences(s: String): List<String> {

            //create a hashmap to store occurences of the 10-char long strings
            val hash = HashMap<String, Int>()

            var i = 0
            var j = 0

            //Initialising the key in which the 10-char long substrings are going to be stored
            var key = ""

            //Performing Sliding window
            while (j < s.length) {

                //storing 10-char long words in key
                key = key.plus(s[j])
                var value = hash.get(key)

                //storing occurrences in hashmap
                if (value == null) {
                    hash.set(key, 0)
                } else {
                    hash.set(key, value + 1)
                }

                if (j < 10) {
                    j++
                    var value = hash.get(key)
                } else if (j - i == 10) {

                    //removing char at ith position of key to make next sliding window and check for now word
                    key = key.drop(1)
                    i++
                    j++
                }

            }

            //checking count of each word in hashmap
            //if count> 1 then adding to list
            var list = mutableListOf<String>()
            for ((key, value) in hash) {
                if (value > 0) {
                    list.add(key)
                }
            }
//            println(hash)

            return list
        }
    }
}

fun main(args: Array<String>) {
    print(RepeatedDNA.findRepeatedDnaSequences("AAAAAAAAAAAAA"))
}