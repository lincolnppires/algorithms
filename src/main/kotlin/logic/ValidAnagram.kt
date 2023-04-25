package logic

// https://leetcode.com/problems/valid-anagram/description/

fun isAnagram(string1: String, string2: String): Boolean {
    var hashLetter = HashMap<Char, Int>()

    if(string1.length != string2.length)
        return false

    for (index in 0 until string1.length) {
        if (hashLetter.contains(string1[index])) {
            hashLetter.put(string1[index], (hashLetter.get(string1[index])!! + 1))
        } else {
            hashLetter.put(string1[index], 1)
        }
    }
    println("Elements in hash")
    hashLetter.forEach { key, value ->
        println("key: $key - value: $value")
    }

    for (index in 0 until string2.length) {
        if (hashLetter.contains(string2[index])) {
            hashLetter.put(string2[index], (hashLetter.get(string2[index])!! - 1))
        }
    }

    println("Elements in after validate anagram")
    hashLetter.forEach { key, value ->
        println("key: $key - value: $value")
    }

    for (value in hashLetter.values) {
        if (value != 0) {
            return false
        }
    }

    return true
}

fun main() {
    println("Result: ${isAnagram("anagram","nagaram")}")
    println("Result: ${isAnagram("rat","cat")}")
}
