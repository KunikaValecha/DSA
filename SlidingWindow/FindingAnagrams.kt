package SlidingWindow

/**
 * Anagram is jumbling of characters in words,
 * e.g. anagrams of word for are rof, orf, ofr, rfo, fro
 * for a word of size n there exist n! anagrams.
 * In case of above eg, 3! = 6 examples exist
 */

class FindingAnagrams {
    companion object {

        //function takes a word of which anagrams are to be determined and
        // a string in which anagrams are to be determined as arguments

        fun findAnagram(inputString: String, pattern: String): Int {

            //Creating a hashmap to store count of occurrences of given word into given string
            val hash = HashMap<Char, Int>()

            //count stores the number of unique keys i.e. unique chars in word
            var count = 0

            //By default, store value of each char in word as what has been there in given word
            //ex, for word "for" f=1, o=1, r=1
            //decrease these value later when they are found in string as per their occurrences
            for (i in pattern) {
                val value = hash.get(i)
                if (value == null) {
                    hash.set(i, 1)
                    count++
                } else {
                    hash.set(i, value + 1)
                }
            }

            //Starting Sliding window
            var i = 0
            var j = 0
            var ans = 0

            while (j < inputString.length) {

                //check if the char of word is found in any of iterations through entire string
                if (hash.contains(inputString[j])) {
                    val value = hash.get(inputString[j])

                    //if the char is present then decrement its value by 1 in hashmap
                    if (value != null) {
                        hash.set(inputString[j], value - 1)

                        //if value of char in hashmap becomes zero then decrease the count by one
                        if (hash.get(inputString[j]) == 0) {
                            count--
                        }
                    }
                }
                if (j < pattern.length - 1) {
                    j++
                } else if (j - i + 1 == pattern.length) {
                    //when count becomes zero that indicates presence of word in string
                    //because each char of given word gets removed from hashmap and eventually from the count
                    //thus increase ans by one to denote the presence of word's anagram successfully observed
                    if (count == 0) {
                        ans++
                    }

                    //roll back the count and value of the char if its == ith element
                    //because as per sliding window the ith element gets removed
                    if (hash.contains(inputString[i])) {
                        val value = hash.get(inputString[j])
                        if (value != null) {
                            hash.set(inputString[j], value + 1)
                            if (hash.get(inputString[j]) == 1) {
                                count++
                            }
                        }
                    }

                    //Slide the window
                    i++
                    j++
                }
            }
            return ans
        }
    }
}

fun main(args: Array<String>) {
    println(FindingAnagrams.findAnagram("abab", "ab"))
}
