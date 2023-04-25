package recursion

// https://www.geeksforgeeks.org/printing-items-01-knapsack/
// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

fun knapSackRecursionMemoization(capacity: Int, weight: IntArray, profit: IntArray, numberOfItens: Int, tableResult: Array<IntArray>): Int {
    if (numberOfItens == 0 || capacity == 0) {
        return 0
    }

    if (tableResult[numberOfItens - 1][ capacity - 1] != -1) {
        return tableResult[numberOfItens - 1][ capacity - 1]
    }

    if (weight[numberOfItens - 1] > capacity) {
        tableResult[numberOfItens - 1][ capacity - 1] = knapSackRecursionMemoization(capacity, weight, profit, numberOfItens - 1, tableResult)
        return tableResult[numberOfItens - 1][ capacity - 1]
    } else {
        tableResult[numberOfItens - 1][ capacity - 1] =
            Math.max(
                knapSackRecursionMemoization(capacity, weight, profit, numberOfItens - 1, tableResult),
                profit[numberOfItens - 1] + knapSackRecursionMemoization(capacity - weight[numberOfItens - 1], weight, profit, numberOfItens - 1, tableResult),
            )
        return tableResult[numberOfItens - 1][ capacity - 1]
    }
}

fun main() {
    var profit = intArrayOf(60, 100, 120)
    var weight = intArrayOf(10, 20, 30)
    var capacity = 50
    var numberOfItens = profit.size

    var tableResult = Array(numberOfItens) { IntArray(capacity) }

    for (i in 0 until tableResult.size) {
        for (j in 0 until tableResult[0].size) {
            tableResult[i][j] = -1
        }
    }

//    for (i in 0 until tableResult.size) {
//        for (j in 0 until tableResult[0].size) {
//            print("|${tableResult[i][j]}")
//        }
//        println()
//    }

    println(knapSackRecursionMemoization(capacity, weight, profit, numberOfItens, tableResult))
}
