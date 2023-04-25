package dynamicprogramming

fun fibonacciDynamic(n: Int): Int {
    val resultTable = IntArray(n + 1)
    resultTable[0] = 0
    resultTable[1] = 1

    for (i in 2 until resultTable.size) {
        resultTable.set(
            i,
            resultTable[i - 1] + resultTable[i - 2],
        )
    }
    return resultTable[n]
}

fun main() {
    println(fibonacciDynamic(5))
    println(fibonacciDynamic(8))
    println(fibonacciDynamic(10))
}
