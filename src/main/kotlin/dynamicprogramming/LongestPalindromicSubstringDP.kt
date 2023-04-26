package dynamicprogramming

fun longestPalindromeDP(word: String): String {
    var lenght = word.length
    var palindromeTable = Array(lenght) { BooleanArray(lenght) }

    // all substring of lenght 1 are palindromes
    var maxLenght = 1
    for (i in 0 until lenght) {
        palindromeTable[i][i] = true
    }
    //printTable(palindromeTable)

    // check for sub-string of lenght 2
    var start = 0
    for (i in 0 until lenght - 1) {
        if (word.get(i) == word.get(i + 1)) {
            palindromeTable[i][i + 1] = true
            start = i
            maxLenght = 2
        }
    }

    // check for lenghts greater than 2
    // k is lenght of substring
    for (k in 3 until lenght) {
        // fix the starting index
        for (i in 0 until lenght - k + 1) {
            // get the ending index of substring from
            // starting index i and length k
            var j = i + k - 1

            // checking for sub-string from ith index to
            // jth index if word[i+1] to word[j-1] is aplindrome
            if ((palindromeTable[i + 1][j - 1]) && word[i] == word[j]) {
                palindromeTable[i][j] = true
                println("Palindrome between $i to $j")
                if (k > maxLenght) {
                    start = i
                    maxLenght = k
                }
            }
        }
    }

    return word.substring(start, start + maxLenght)
}

fun main() {
    println("Result: ${longestPalindromeDP("geeks")}")
    println("Result: ${longestPalindromeDP("forgeeksskeegfor")}")
}

private fun printTable(palindromeTable: Array<BooleanArray>) {
    palindromeTable.forEach {
        it.forEach { print("|$it") }
        println()
    }
}
