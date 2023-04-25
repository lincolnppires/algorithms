package logic

fun firstUniqueChar(word: String): Int {
    var bucketChar = IntArray(26)

    for (i in 0 until word.length) {
        var index = word.get(i) - 'a'
        bucketChar[index]++
    }

    for (i in 0 until word.length) {
        var index = word.get(i) - 'a'

        if (bucketChar[index] == 1) {
            return i
        }
    }

    return -1
}

fun main() {
    println("Result: ${firstUniqueChar("leetcode")}")
    println("Result: ${firstUniqueChar("loveleetcode")}")
    println("Result: ${firstUniqueChar("aabb")}")
}
