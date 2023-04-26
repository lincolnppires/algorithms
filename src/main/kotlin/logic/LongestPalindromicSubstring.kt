package logic

// https://www.geeksforgeeks.org/longest-palindromic-substring/
// https://www.youtube.com/watch?v=JODTMxEeznY&t=408s

fun longestPalindrome(word: String): String {
    var maxLenght = 0
    var start = -1

    for (i in 0 until word.length) {
        var length = Math.max(
            getLenght(i, i, word),
            getLenght(i, i + 1, word),
        )

        if (maxLenght < length) {
            maxLenght = length
            start = i - (length - 1) / 2
        }
    }
    return word.substring(start, start + maxLenght)
}

private fun getLenght(i: Int, j: Int, word: String): Int {
    var lenght = 0
    if (j >= word.length) {
        return 0
    }

    if (i == j) {
        lenght = -1
        return lenght
    }

    var indexLow = i
    var indexHigh = j

    while (indexLow >= 0 && indexHigh < word.length) {
        if (word.get(indexLow) != word.get(indexHigh)) {
            break
        }

        lenght += 2
        indexLow--
        indexHigh++
    }

    return lenght
}

fun main() {
    println("Result: ${longestPalindrome("Geeks")}")
}
