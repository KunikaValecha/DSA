package SlidingWindow

import kotlin.math.min

class MinimumWindowSubstring {
    companion object {
        fun minWindow(s: String, t: String): String {
            val hash = hashMapOf<Char, Int>()

            for (i in t) {
                val value = hash.get(i)
                if (value == null)
                    hash.set(i, 1)
                else
                    hash.set(i, hash.get(i)!! + 1)
            }
            var count = hash.size
            var j = 0
            var i = 0
            var minLen = Int.MAX_VALUE
            var str: String = ""

            while (j < s.length) {
                val value = hash.get(s[j])
                if (value != null) {
                    hash.set(s[j], hash.get(s[j])!! - 1)
                    if (hash.get(s[j])!! == 0) {
                        count--
                    }
                }
                if (count > 0) {
                    j++
                } else if (count == 0) {
                    while (count == 0) {
                        val newVal = hash.get(s[i])
                        if (newVal != null) {
                            hash.set(s[i], hash.get(s[i])!! + 1)
                            if (hash.get(s[i]) == 1) {
                                count++
                            }
                        }
                        val newLength = j - i + 1
                        if (minLen > newLength) {
                            minLen = newLength
                            str = s.substring(i, j + 1)
                        }
                        i++
                    }
                    j++
                }
            }
            return str
        }
    }
}

fun main() {
    println(MinimumWindowSubstring.minWindow(s = "a", t = "aa"))
}