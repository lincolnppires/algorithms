package recursion

// https://www.geeksforgeeks.org/printing-items-01-knapsack/
// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

fun knapSackRecursion(capacity: Int, weight: IntArray, profit: IntArray, numberOfItens: Int): Int {
    if (numberOfItens == 0 || capacity == 0) {
        return 0
    }

    if (weight[numberOfItens - 1] > capacity) {
        return knapSackRecursion(capacity, weight, profit, numberOfItens - 1)
    } else {
        return Math.max(
            knapSackRecursion(capacity, weight, profit, numberOfItens - 1),
            profit[numberOfItens - 1] + knapSackRecursion(capacity - weight[numberOfItens - 1], weight, profit, numberOfItens - 1),
        )
    }
}

fun main() {
    var profit = intArrayOf(60, 100, 120)
    var weight = intArrayOf(10, 20, 30)
    var capacity = 50
    var numberOfItens = profit.size
    println(knapSackRecursion(capacity, weight, profit, numberOfItens))
}
